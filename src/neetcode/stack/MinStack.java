package neetcode.stack;

import java.util.Arrays;

public class MinStack {
    private static final int DEFAULT_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE - 8;

    private int[] data;
    private int size;
    private int[] minStack;

    public MinStack() {
        this.data = new int[DEFAULT_CAPACITY];
        this.minStack = new int[DEFAULT_CAPACITY];
    }

    public void push(int value) {
        if (data.length == size) {
            grow();
        }

        int currentMin;
        if (size == 0) {
            currentMin = value;
        } else {
            currentMin = Math.min(value, minStack[size - 1]);
        }

        data[size] = value;
        minStack[size] = currentMin;
        size++;
    }

    public void pop() {
        if (size > 0) {
            size--;
        }
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return minStack[size - 1];
    }

    private void grow() {
        if (data.length >= MAXIMUM_CAPACITY) {
            throw new OutOfMemoryError();
        }
        int newCapacity = Math.min(data.length * 2, MAXIMUM_CAPACITY);
        data = Arrays.copyOf(data, newCapacity);
        minStack = Arrays.copyOf(minStack, newCapacity);
    }
}
