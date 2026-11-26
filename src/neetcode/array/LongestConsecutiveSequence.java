package neetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }

        return maxStreak;
    }

    // my solution O(NlogN) & O(N) - I decided to implement merge sort just for practice
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        sort(nums, 0, nums.length - 1);

        int sequence = 1;
        int maxSequence = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else if (nums[i] == nums[i-1] + 1) {
                sequence++;
                maxSequence = Math.max(maxSequence, sequence);
            } else {
                sequence = 1;
            }
        }

        return maxSequence;
    }

    static void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(nums, left, mid);
            sort(nums, mid + 1, right);

            mergeSort(nums, left, mid, right);
        }
    }

    static void mergeSort(int[] nums, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(nums, left, leftArray, 0, leftSize);
        System.arraycopy(nums, mid + 1, rightArray, 0, rightSize);

        int i = 0, j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
                k++;
            } else {
                nums[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftSize) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
