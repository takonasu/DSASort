public class ShellSort {
    public ShellSort(int[] arr) {
        // ギャップ列の生成(Sedgewick)
        final int ARRAY_LENGTH = 10;
        int[] G = new int[ARRAY_LENGTH];
        for (int i = 0; i < G.length; i++) {
            if (i == 0)
                G[i] = 1;
            else
                G[i] = (int) Math.pow(4, i) + 3 * (int) Math.pow(2, i - 1) + 1;
        }

        for (int k = G.length - 1; 0 <= k; k--)
            for (int i = G[k]; i < arr.length; i = i + G[k]) {
                int tmp = arr[i];
                int j = i - G[k];
                while (0 <= j && tmp < arr[j]) {
                    arr[j + G[k]] = arr[j];
                    j = j - G[k];
                }
                arr[j + G[k]] = tmp;
            }

        // 確認
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }
    }
}
