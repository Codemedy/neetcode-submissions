package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pastIndex = stack.pop();
                result[pastIndex] = i - pastIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
