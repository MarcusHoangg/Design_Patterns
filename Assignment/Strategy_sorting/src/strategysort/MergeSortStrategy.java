package strategysort;

public class MergeSortStrategy implements SortStrategy {

    @Override
    public String name() {
        return "MergeSort";
    }

    @Override
    public void sort(int[] arr) {
        if (arr.length <= 1) return;
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;

        mergeSort(a, tmp, left, mid);
        mergeSort(a, tmp, mid + 1, right);
        merge(a, tmp, left, mid, right);
    }

    private void merge(int[] a, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= right) tmp[k++] = a[j++];

        for (int x = left; x <= right; x++) {
            a[x] = tmp[x];
        }
    }
}