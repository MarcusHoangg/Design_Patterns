package strategysort;

public class HeapSortStrategy implements SortStrategy {

    @Override
    public String name() {
        return "HeapSort";
    }

    @Override
    public void sort(int[] arr) {
        heapSort(arr);
    }

    private void heapSort(int[] a) {
        int n = a.length;

        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // extract elements
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end);
            heapify(a, end, 0);
        }
    }

    private void heapify(int[] a, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && a[left] > a[largest]) largest = left;
        if (right < heapSize && a[right] > a[largest]) largest = right;

        if (largest != i) {
            swap(a, i, largest);
            heapify(a, heapSize, largest);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}