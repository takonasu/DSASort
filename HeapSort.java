public class HeapSort {
    public HeapSort(int[] arr) {

        for (int n = arr.length; 0 < n; n--) {
            buildHeap(arr, n);
            int tmp = arr[n - 1];
            arr[n - 1] = arr[0];
            arr[0] = tmp;
        }

        // // 確認
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
    }

    public void buildHeap(int[] A, int n) {
        // Math.ceil(n / 2) - 1 => 一番最後のノードの親
        for (int x = (int) Math.ceil(n / 2) - 1; 0 <= x; x--) {
            shift_down(A, x, n);
        }
    }

    public void shift_down(int[] A, int x, int n) {

        // 子が存在する間は実行
        while (2 * x + 1 <= n - 1) {
            // 子の値とインデックス（子が二つある場合は小さいほうの子）
            int childIndex = 0;

            // 右の子が存在するか
            if (2 * x + 2 <= n - 1) {
                // 左の子が右の子より大きい時
                if (A[2 * x + 1] < A[2 * x + 2]) {
                    childIndex = 2 * x + 1;
                } else {
                    childIndex = 2 * x + 2;
                }
            } else {
                childIndex = 2 * x + 1;
            }

            // 親の値と子の小さいほう値を比較
            if (A[childIndex] <= A[x]) {
                int tmp = A[x];
                A[x] = A[childIndex];
                A[childIndex] = tmp;
            } else {
                return;
            }

            x = childIndex;

        }
    }
}
