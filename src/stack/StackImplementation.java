package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackImplementation <T> {

    private static final byte DEFAULT_CAPACITY = 16;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;

    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImplementation(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can not be 0 or less");
        }
        this.array = (T[]) new Object[Math.max(capacity, 1)];
    }

    public StackImplementation(){
        this(DEFAULT_CAPACITY);
    }

    public T peek() {
        if (size == 0) throw new EmptyStackException();
        return array[size - 1];
    }

    public void push(T num){
        if (size == array.length) grow();
        array[size++] = num;
    }

    public T pop(){
        if (array.length == 0 || size <= 0) {
            throw new EmptyStackException();
        }
        int index = --size;
        T value = array[index];
        array[index] = null;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }



    private void grow() {
        if (array.length >= MAX_CAPACITY) {
            throw new OutOfMemoryError("Stack is too large");
        }
        int newCapacity = (int) Math.min( (long) array.length * 2, MAX_CAPACITY);
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public String toString() {
        return "StackImplementation{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
