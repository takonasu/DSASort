public class MergeSort2 {
    public MergeSort2(int[] arr) {
        int[] A = { 8, 15, 1, 9, 30, 27, 6, 5, 98, 42, 10, 57, 31 };
        merge_sort(A, 0, A.length - 1);

        // 確認
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }
    }

    public void merge_sort(int[] A, int left, int right) {
        if (left == right) {

            return;
        }

        int split = (int) Math.floor((left + right) / 2);
        merge_sort(A, left, split);
        merge_sort(A, split + 1, right);
        merge(A, split, left, right);
    }

    public void merge(int[] A, int split, int left, int right) {
        int[] B = new int[A.length];
        int l = left;
        int r = split + 1;
        int k = 0;

        while (l <= split && r <= right) {
            if (A[l] <= A[r]) {
                B[k] = A[l];
                l++;
            } else {
                B[k] = A[r];
                r++;
            }
            k++;
        }

        if (l == split + 1) {
            while (r <= right) {
                B[k] = A[r];
                r++;
                k++;
            }
        } else {
            while (l <= split) {
                B[k] = A[l];
                l++;
                k++;
            }
        }

        for (int i = left; i <= right; i++) {
            A[i] = B[i - left];
        }

        // 確認
        for (int i = left; i <= right; i++) {
            System.out.print(A[i] + ",");
        }
        System.out.println();
    }
}
