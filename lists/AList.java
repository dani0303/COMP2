package lists;

import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;

public class AList <T> implements ListInterface <T> {

    private T[] list;
    private int numberOfEntries;
    private int capacity;
    public static final int DEFAULT_CAPACITY = 10;
    public static final int MAX_CAPACITY = 10000;

    //construtor
    public AList(int capacity) {
        list = (T[]) new Object[capacity];
        this.capacity = capacity;
        numberOfEntries = 0;
    }

    //default constructor
    public AList()  {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T newEntry) {
        if(newEntry == null) {
            throw new IllegalArgumentException();
        }
        list[numberOfEntries ++] = newEntry;
        ensureCapacity();
    }

    private void ensureCapacity() {
        if(isFull()) {
            capacity *= 2;
        }
        checkCapacity();
        list = Arrays.copyOf(list, capacity);
    }

    private boolean isFull() {
        return numberOfEntries == capacity;
    }

    private void checkCapacity() {
        if(capacity >= MAX_CAPACITY) {
            throw new RejectedExecutionException();
        }
    }

    @Override
    public void add(int givenPosition, T newEntry) {
        if(givenPosition < 0 || givenPosition > numberOfEntries) {
            throw new IndexOutOfBoundsException();
        }

        makeRoom(givenPosition);
        list[givenPosition] = newEntry;
        numberOfEntries ++;
    }

    private void makeRoom(int position) {
        for(int i = numberOfEntries - 1; i >= position; i --) {
            list[i + 1] = list[i];
        }
    }

    @Override
    public T remove(int givenPosition) {
        if(givenPosition < 0 || givenPosition >= numberOfEntries) {
            throw new IndexOutOfBoundsException();
            T out = list[givenPosition];
            fillGap(givenPosition);
            numberOfEntries --;
            return out;
        }

    }

    private void fillGap(int position) {
        for(int i = position; i < numberOfEntries; i ++)
        {
            list[i] = list[i ++];
        }
    }

    @Override
    public boolean remove(T anEntry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public T getEntry(int givenPosition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEntry'");
    }

    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLength'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        //COPY FROM ARRAY BAG
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    
}
