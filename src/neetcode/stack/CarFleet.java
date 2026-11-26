package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length != speed.length) throw new IllegalArgumentException();

        int n = position.length;
        if (n == 1) return 1;
        double[][] cars = new double[n][2];
        Deque<Double> stack = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        for (double[] car : cars) {
            double time = car[1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

        }

        return stack.size();
    }
}
