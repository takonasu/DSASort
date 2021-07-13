import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 100000;

        int[] A = new int[ARRAY_LENGTH];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(ARRAY_LENGTH * 100);
        }

        long startTime, endTime;

        // 単純ソート
        startTime = System.currentTimeMillis();
        new SimpleSort(A);
        endTime = System.currentTimeMillis();
        System.out.println("単純ソート：経過時間" + (endTime - startTime) + "ms");

        // 選択ソート
        startTime = System.currentTimeMillis();
        new SelectionSort(A);
        endTime = System.currentTimeMillis();
        System.out.println("選択ソート：経過時間" + (endTime - startTime) + "ms");

        // バブルソート
        startTime = System.currentTimeMillis();
        new BubbleSort(A);
        endTime = System.currentTimeMillis();
        System.out.println("バブルソート：経過時間" + (endTime - startTime) + "ms");

        // 改良バブルソート
        startTime = System.currentTimeMillis();
        new BetterBubbleSort(A);
        endTime = System.currentTimeMillis();
        System.out.println("改良バブルソート：経過時間" + (endTime - startTime) + "ms");
    }
}