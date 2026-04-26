package fibonacci;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int previous = 0;
    private int current = 1;

    @Override
    public boolean hasNext() {
        return true; // Fibonacci can continue indefinitely
    }

    @Override
    public Integer next() {
        int nextValue = current;
        int newCurrent = previous + current;

        previous = current;
        current = newCurrent;

        return nextValue;
    }
}