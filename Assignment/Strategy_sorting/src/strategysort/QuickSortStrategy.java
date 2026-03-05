package strategysort;

import java.util.Random;

public class QuickSortStrategy implements SortStrategy {
    private final Random random = new Random();

    @Override
    public String name() {
        return "QuickSort (random pivot)";
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivot = a[pivotIndex];

        // partition
        int i = left, j = right;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        if (left < j) quickSort(a, left, j);
        if (i < right) quickSort(a, i, right);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}