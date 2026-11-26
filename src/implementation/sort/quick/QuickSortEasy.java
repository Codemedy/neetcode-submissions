package implementation.sort.quick;

import java.util.ArrayList;
import java.util.List;

public class QuickSortEasy {

    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() <= 1) return arr;

        int pivot = arr.getLast();
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int a : arr) {
            if (a < pivot) {
                less.add(a);
            } else if (a > pivot) {
                greater.add(a);
            } else {
                equal.add(a);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(quickSort(less));
        result.addAll(equal);
        result.addAll(quickSort(greater));

        return result;
    }

    static void main() {
        List<Integer> unsorted = List.of(5,1,3,8,5,2,9,8);
        System.out.println(quickSort(unsorted));
    }
}
