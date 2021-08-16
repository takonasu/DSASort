# 実行方法
Main.javaのメインメソッドを実行


# ソートアルゴリズムまとめ
| アルゴリズム     | 最悪計算量       | 平均計算量 | 最良計算量 | 安定性       | 備考                                                      | 
| ---------------- | ---------------- | ---------- | ---------- | ------------ | --------------------------------------------------------- | 
| 単純ソート       | $ n^{2}$         | $ n^{2}$   | $ n^{2}$   | 安定ではない  |                                                           | 
| 選択ソート       | $ n^{2}$         | $ n^{2}$   | $ n^{2}$   | 安定ではない |                                                           | 
| バブルソート     | $ n^{2}$         | $ n^{2}$   | $ n^{2}$   | 安定         |                                                           | 
| 改良バブルソート | $ n^{2}$         |            | $ n$       | 安定         | 一度も隣同士で交換されない場合は処理を終了する            | 
| 挿入ソート       | $ n^{2}$         | $ n^{2}$   | $ n$       | 安定         |                                                           | 
| シェルソート     | $ n\sqrt{n}$ (?) | ---        |            | 安定ではない | ギャップ列がSedgewickの場合．平均計算量は未解決問題らしい | 
| ヒープソート     | $ nlog(n)$       | $ nlog(n)$ | $ nlog(n)$  | 安定ではない |                                                           | 
| クイックソート   | $ n^{2}$         | $ nlog(n)$ | $ nlog(n)$ | 安定ではない |                                                           | 
| マージソート     | $ nlog(n)$       | $ nlog(n)$  | $ nlog(n)$ | 安定         |                                                           | 
| バケットソート   | $ n^2$    | $ n + k$ |  $  n $ |   安定   |        kはバケットの数                   | 
| 基数ソート       |  $ nk$      |            |            |   安定   |      kは桁数      | 
# 安定性について
安定とは，ソート前とソート後で同じ値同士での順序が変わらないということである．  
例） `{年齢，名前} = {15, 嵐 千砂都}, {16, 南ことり}, {16, 澁谷かのん}, {17, 高坂穂乃果}, {15, 唐可可}`  
これを年齢順にソートしたとする．安定なアルゴリズムの場合は，  
`{年齢，名前} = {15, 嵐 千砂都}, {15, 唐可可}, {16, 南ことり}, {16, 澁谷かのん}, {17, 高坂穂乃果} `  
とソートされるはずである．しかし，不安定なアルゴリズムの場合は，  
`{年齢，名前} = {15, 唐可可}, {15, 嵐 千砂都}, {16, 澁谷かのん}, {16, 南ことり}, {17, 高坂穂乃果} `  
のようになる場合がある．このように，同値同士の順番がソート前後で保たれないものが，不安定なソートアルゴリズムである．

## 単純ソートと選択ソートの安定性
単純ソートで上記の例をソートしてみる．もちろん，不安定にならない場合もあるが，以下のように不安定にソートされることもある．  
`{年齢，名前} = {15, 嵐 千砂都}, {16, 南ことり}, {16, 澁谷かのん}, {17, 高坂穂乃果}, {15, 唐可可}`  
`{年齢，名前} = {15, 嵐 千砂都}, {15, 唐可可}, {16, 澁谷かのん}, {17, 高坂穂乃果}, {16, 南ことり}`  
`{年齢，名前} = {15, 嵐 千砂都}, {15, 唐可可}, {16, 澁谷かのん}, {16, 南ことり}, {17, 高坂穂乃果}`  
このように，不安定である．

## シェルソートの安定性
シェルソートはギャップによって飛ばし飛ばしでソートしたのち，ギャップを小さくしていって最終的にはギャップを１でソートする．そもそも，飛ばし飛ばしでソートする時点で安定性が失われることが想像できる．

## ヒープソートの安定性
ヒープを構築した時点で安定性の概念はない．（そうだよね？ハム太郎？）

## クイックソートの安定性
安定じゃなくなる例  
`3,10,10`  
があった時，ピボットを右端にするとrは3でストップし．lは10でストップする，  
一般的なアルゴリズムでは，lとピボットを交換する．  
よって10と10が入れ替えられてしまうため安定性が失われる．