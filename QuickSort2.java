public class QuickSort2 {
    public QuickSort2(int[] arr) {
        int[] A = { 5, 8, 6, 10, 1, 3, 4, 11, 7 };
        quick_sort(A, 0, A.length - 1);

        // 確認
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }
    }

    public void quick_sort(int[] A, int left, int right) {
        int p = 0;
        if (left < right) {
            int pivot = right;
            p = partition(A, pivot, left, right);
            // 確認
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i] + ",");
            }
            System.out.println();

            quick_sort(A, left, p - 1);
            quick_sort(A, p + 1, right);
        }
    }

    public int partition(int[] A, int pivot, int left, int right) {
        int tmp = A[right];
        A[right] = A[pivot];
        A[pivot] = tmp;

        int l = left;
        int r = right - 1;

        while (true) {
            while (A[l] < A[right]) {
                l++;
            }

            while (l <= r && A[right] <= A[r]) {
                r--;
            }

            if (l < r) {
                tmp = A[l];
                A[l] = A[r];
                A[r] = tmp;
            } else {
                break;
            }
        }

        tmp = A[right];
        A[right] = A[l];
        A[l] = tmp;

        return l;
    }
}
