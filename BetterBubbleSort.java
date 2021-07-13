public class BetterBubbleSort {
    public BetterBubbleSort(int[] arr) {
        boolean sort = false;
        for (int i = 0; i < arr.length - 1; i++) {
            sort = false;
            for (int j = arr.length - 1; i < j; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                    sort = true;
                }
            }
            if (!sort)
                break;
        }

        // 確認
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
    }
}
