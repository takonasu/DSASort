public class Dijkstra {
    // 重みの最大値
    int M = 10000000;
    // 隣接行列
    int[][] R = { { 0, 80, M, 30, M }, { M, 0, 30, M, M }, { M, M, 0, M, M }, { M, 50, M, 0, 10 },
            { M, 20, 40, M, 0 } };
    // 訪問済みか記録する行列（ノード数5）
    boolean[] S = { false, false, false, false, false };
    // 各ノードへの最短コスト（ノード数5） ←求めたいもの
    // 必ず0から出発すると仮定する
    int[] d = { 0, M, M, M, M };

    Dijkstra() {
        try_dijkstra(0);
    }

    void try_dijkstra(int nodeNumber) {

        S[nodeNumber] = true;

        for (int i = 0; i < R[nodeNumber].length; i++) {
            if (R[nodeNumber][i] != 0 && R[nodeNumber][i] + d[nodeNumber] < d[i]) {
                d[i] = R[nodeNumber][i] + d[nodeNumber];
            }
        }

        // 未訪問のノードでコストが一番小さいものを選択
        int minIndex = 0;
        int minValue = M;
        for (int i = 0; i < d.length; i++) {
            if (S[i] == false && d[i] < minValue) {
                minIndex = i;
                minValue = d[i];
            }
        }

        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();

        for (int i = 0; i < d.length; i++) {
            System.out.print(S[i] + ",");
        }
        System.out.println();

        if (minIndex != 0)
            try_dijkstra(minIndex);
    }
}