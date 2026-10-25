package neetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[] {};

        Map<Integer,Integer> map = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
