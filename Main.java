import java.util.Random;

public class Main {

    static int ARRAY_LENGTH = 50000;

    static int[] makeRandom() {

        int[] A = new int[ARRAY_LENGTH];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(ARRAY_LENGTH * 100);
        }
        return A;
    }

    public static void main(String[] args) {

        long startTime, endTime;

        // 単純ソート
        startTime = System.currentTimeMillis();
        new SimpleSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("単純ソート：経過時間" + (endTime - startTime) + "ms");

        // 選択ソート
        startTime = System.currentTimeMillis();
        new SelectionSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("選択ソート：経過時間" + (endTime - startTime) + "ms");

        // バブルソート
        startTime = System.currentTimeMillis();
        new BubbleSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("バブルソート：経過時間" + (endTime - startTime) + "ms");

        // 改良バブルソート
        startTime = System.currentTimeMillis();
        new BetterBubbleSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("改良バブルソート：経過時間" + (endTime - startTime) + "ms");

        // 挿入ソート
        startTime = System.currentTimeMillis();
        new InsertionSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("挿入ソート：経過時間" + (endTime - startTime) + "ms");

        // シェルソート
        startTime = System.currentTimeMillis();
        new ShellSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("シェルソート：経過時間" + (endTime - startTime) + "ms");

        // ヒープソート
        startTime = System.currentTimeMillis();
        new HeapSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("ヒープソート：経過時間" + (endTime - startTime) + "ms");

        // クイックソート
        startTime = System.currentTimeMillis();
        new QuickSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("クイックソート：経過時間" + (endTime - startTime) + "ms");

        // マージソート
        startTime = System.currentTimeMillis();
        new MergeSort(makeRandom());
        endTime = System.currentTimeMillis();
        System.out.println("マージソート：経過時間" + (endTime - startTime) + "ms");

        // バケットソート
        startTime = System.currentTimeMillis();
        new BucketSort(makeRandom(), ARRAY_LENGTH * 100);
        endTime = System.currentTimeMillis();
        System.out.println("バケットソート：経過時間" + (endTime - startTime) + "ms");

        // 基数ソート
        // 桁数が多いとjava.lang.StackOverflowErrorを出すので注意
        startTime = System.currentTimeMillis();
        new RadixSort(makeRandom(), ARRAY_LENGTH * 100);
        endTime = System.currentTimeMillis();
        System.out.println("基数ソート：経過時間" + (endTime - startTime) + "ms");
    }
}