package neetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);

            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }

            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
