package neetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> result = new HashSet<>(nums.length);

        for(int n : nums) {
            if (!result.add(n)) return true;
        }

        return false;
    }
}
