package neetcode.two_pointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrainingRainWater {
    public int trap1(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int sum = 0;

        int currentMaxLeft = 0;
        for (int i = 0; i < n; i++) {
            currentMaxLeft = Math.max(height[i], currentMaxLeft);
            maxLeft[i] = currentMaxLeft;
        }

        int currentMaxRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            currentMaxRight = Math.max(height[i], currentMaxRight);
            maxRight[i] = currentMaxRight;
        }

        for (int i = 0; i < n; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                sum += water;
            }
        }

        return sum;
    }

    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int sum = 0;
        int left = 0;
        int right = n - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                int water = maxLeft - height[left];
                if (water > 0) {
                    sum += water;
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                int water = maxRight - height[right];
                if (water > 0) {
                    sum += water;
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }

        return sum;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        int current = 0;

        while (current < n) {
            while(!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int bottomIndex = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int leftIndex = stack.peek();
                int distance = current - leftIndex - 1;
                int boundedHeight = Math.min(height[current], height[leftIndex]) - height[bottomIndex];

                sum += distance * boundedHeight;
            }

            stack.push(current);
            current++;
        }

        return sum;
    }
}
