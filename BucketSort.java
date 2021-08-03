public class BucketSort {
    public BucketSort(int[] arr, int max) {
        Bucket[] BucketArray = new Bucket[max];
        // バケットの生成
        for (int i = 0; i < BucketArray.length; i++) {
            BucketArray[i] = new Bucket();
        }
        // バケットに挿入
        for (int i = 0; i < arr.length; i++) {
            BucketArray[arr[i]].add(arr[i]);
        }
        // ソート結果を格納
        int j = 0;
        for (int i = 0; i < BucketArray.length; i++) {
            if (BucketArray[i].number != -1) {
                Bucket tmp = BucketArray[i];
                while (tmp.NextHop != null) {
                    arr[j] = tmp.number;
                    j++;
                    tmp = tmp.NextHop;
                }
            }
        }

        // 確認
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }

    }
}

class Bucket {
    int number;
    Bucket NextHop;

    public Bucket() {
        this.number = -1;
        this.NextHop = null;
    }

    public void add(int addNumber) {
        if (this.NextHop == null) {
            this.number = addNumber;
            this.NextHop = new Bucket();
        } else {
            NextHop.add(addNumber);
        }
    }
}
