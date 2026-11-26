package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1) return heights[0];
        Deque<int[]> stack = new ArrayDeque<>(n);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > currentHeight) {
                int[] popped = stack.pop();
                int index = popped[0];
                int height = popped[1];

                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }

            stack.push(new int[]{start, currentHeight});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];

            maxArea = Math.max(maxArea, height * (n - index));
        }

        return maxArea;
    }
}
