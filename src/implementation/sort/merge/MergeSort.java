package implementation.sort.merge;

public class MergeSort {

    static void merge(int[] data, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(data, left, leftArray, 0, leftSize);
        System.arraycopy(data, mid + 1, rightArray, 0, rightSize);

        int i = 0,j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
                k++;
            } else {
                data[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //fill in the remaining values
        while (i < leftSize) {
            data[k] = leftArray[i];
            i++;
            k++;
        }

        //fill in the remaining values
        while (j < rightSize) {
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }

    //https://devakinandan.medium.com/why-use-mid-left-right-left-2-instead-of-mid-left-right-2-to-calculate-the-midpoint-1a947e37f78a
    static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);

            merge(data, left, mid, right);
        }
    }

    static void main() {
        int[] array = { 38, 27, 43, 10, 29 };

        mergeSort(array, 0, array.length - 1);

        for (int el : array) System.out.print(el + " ");
    }
}
