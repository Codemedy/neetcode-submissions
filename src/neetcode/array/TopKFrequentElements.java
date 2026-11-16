package neetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    //my solution
    public int[] topKFrequent1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        if (n == 1) return new int[] {nums[0]};

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = map.entrySet().stream().sorted(
                        Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return result;
    }

    //optimal solution using bucket sort
    public int[] topKFrequent2(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[n + 1];
        for (int key : countMap.keySet()) {
            int frequency = countMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
