package utils;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> 
{
    private T[] stackArray;
    private int capacity;
    private int stackLength;
    private int topIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAP = 10;

    public ArrayStack(int capacity)
    {
        stackArray = (T[]) new Object[capacity];
        this.capacity = capacity;
        topIndex = -1;
    }

    public ArrayStack()
    {
        this(DEFAULT_CAP);
    }

    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        T outData = stackArray[stackLength - 1];
        stackArray[stackLength - 1] = null;
        stackLength --;
        return outData;
    }

    public T peek()
    {
        topIndex = stackLength - (stackLength - 1);
        return stackArray[topIndex];
    }

    public void push(T entry)
    {
        if(isFull())
        {
            //double capacity in the array
            ensureCapacity();
        }
        stackArray[topIndex + 1] = entry;
        topIndex ++;
    }

    public void clear()
    {
        if(capacity > DEFAULT_CAP)
        {
            capacity = DEFAULT_CAP;
        }
        stackArray = (T[]) new Object[capacity];
    }

    public boolean isEmpty()
    {
        return stackLength == 0;
    }

    private void ensureCapacity()
    {
        capacity*=2;
        stackArray = Arrays.copyOf(stackArray, capacity);
    }

    private boolean isFull()
    {
        return stackLength == capacity;
    }
}
