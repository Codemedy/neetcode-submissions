package implementation.sort.quick;

public class QuickSortRepeat {

    static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        System.out.println("pivot is: " + pivot);
        int i = low - 1;
        System.out.println("i in partition is: " + i);

        for (int j = low; j < high; j++) {
            System.out.println("current j: " + j + " and high: " + high + " and data[j]: " + data[j]);
            System.out.println("Is " + data[j] + " < " + pivot + " ?");
            if (data[j] < pivot) {
                i++;
                System.out.println("Yes, then i++ value is -> " + i + " , doing swap -> " + data[i] + " " + data[j]);
                swap(data, i, j);
            }
        }

        System.out.println("At the end of method doing SWAP between " + data[i+1] + " and " + data[high]);
        swap(data, i + 1, high);
        System.out.println("Return i + 1 as PIVOT INDEX");
        return i + 1;
    }

    static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    static void quickSort(int[] data, int low, int high) {
        System.out.println("Current low & high: " + low + ", " + high);
        if (low < high) {
            int pivotIndex = partition(data, low, high);
            System.out.println("Result of pivotIndex: " + pivotIndex);

            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);
        }
    }

    static void main() {
        int[] data = { 7, 8, 1, 3, 6, 9, 11, 2};

        quickSort(data, 0, data.length - 1);

        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
