package strategysort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100000;

        int[] small = generateRandomArray(smallSize, 0, 1000, 42);
        int[] large = generateRandomArray(largeSize, 0, 1_000_000, 42);

        SortStrategy[] strategies = new SortStrategy[] {
                new QuickSortStrategy(),
                new MergeSortStrategy(),
                new HeapSortStrategy()
        };

        System.out.println("=== Strategy Pattern: Sorting Performance Comparison ===");
        System.out.println("Small array size: " + smallSize);
        runBench("SMALL", small, strategies);

        System.out.println("\nLarge array size: " + largeSize);
        runBench("LARGE", large, strategies);
    }

    private static void runBench(String label, int[] original, SortStrategy[] strategies) {
        for (SortStrategy s : strategies) {
            int[] copy = original.clone(); // same dataset for fairness

            long start = System.nanoTime();
            s.sort(copy);
            long end = System.nanoTime();

            boolean ok = isSorted(copy);
            double ms = (end - start) / 1_000_000.0;

            System.out.printf("[%s] %-24s : %8.3f ms   sorted=%s%n",
                    label, s.name(), ms, ok);
        }
    }

    private static int[] generateRandomArray(int n, int min, int max, long seed) {
        Random r = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = min + r.nextInt(max - min + 1);
        }
        return a;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }
}