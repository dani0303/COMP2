package utils;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;

public class AList<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;

    public AList(int capacity) {
        if(capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        else {
            //checkCapacity(capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
        numberOfEntries = 0;
    }

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public Object [] toArray() {
        Object[] result = new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i ++) {
            result[i] = list[i];
        }
        return result;
    }

    private void checkCapacity(int capacity) {
        if(capacity >= MAX_CAPACITY) {
            throw new RejectedExecutionException("Capacity too big");
        }
    }

    public static void main(String[] args) {
        AList animals = new AList<String>();
        animals.add("cats");
        animals.add("parrot");
        animals.add("monkey");
        animals.add("lion");
        animals.add("tiger");
        //Print list
        Object[] obj = animals.toArray();
        for(int i = 0; i < obj.length; i ++) {
            System.out.println(obj[i]);
        }
        //Remove an object from the list
        animals.remove(1);
        //Print list
        System.out.println();
        Object[] obj1 = animals.toArray();
        for(int i = 0; i < obj1.length; i ++) {
            System.out.println(obj1[i]);
        }
        //Remove an object from the list
        //Print list
        System.out.println(animals.remove("cats"));
        Object[] obj2 = animals.toArray();
        for(int i = 0; i < obj2.length; i ++) {
            System.out.println(obj2[i]);
        }
    }

    @Override
    public void add(int newPosition, T newEntry) {
        // TODO Auto-generated method stub
        if(newPosition < 0 || newPosition > numberOfEntries)
            throw new IndexOutOfBoundsException();
        makeRoom(newPosition);
        list[newPosition] = newEntry;
        numberOfEntries ++;
        ensureCapacity();
    }

    @Override
    public T remove(int givenPosition) {
        // TODO Auto-generated method stub
        if((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
            T result = list[givenPosition];
            if(givenPosition < numberOfEntries)
                removeGap(givenPosition);
            list[numberOfEntries] = null;
            numberOfEntries --;
            return result;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        for(int i = removedIndex; i < numberOfEntries; i ++) {
            list[i] = list[i + 1];
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        T[] temp = (T[]) new Object[0];
        list = temp;
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        // TODO Auto-generated method stub
        T temp = null;
        if(givenPosition < 0 || givenPosition > numberOfEntries)
            throw new IndexOutOfBoundsException();
        for(int i = 0; i < list.length; i ++) {
            if(i == givenPosition) {
                temp = list[i];
                list[i] = newEntry;
            }
        }
        return temp;
    }

    @Override
    public T getEntry(int givenPosition) {
        // TODO Auto-generated method stub
        T result = null;
        if(givenPosition < 0 || givenPosition > numberOfEntries)
            throw new IndexOutOfBoundsException();
        for(int i = 0; i < list.length; i ++) {
            if(i == givenPosition) {
                result = list[i];
            }
        }
        return result;
    }

    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return numberOfEntries == 0;
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        boolean found = false;
        int index = 0;
        while(!found && (index <= numberOfEntries)) {
            if(anEntry.equals(list[index])) {
                found = true;
            }
            index ++;
        }
        return found;
    }

    private void makeRoom(int newPosition) {
        assert(newPosition >= 0 && newPosition <= numberOfEntries);
        for(int i = numberOfEntries; i < newPosition; i --) {
            list[i] = list[i - 1];
        }
    }

    @Override
    public boolean remove(T anEntry) {
        // TODO Auto-generated method stub
        if(contains(anEntry)) {
            for(int i = 0; i < numberOfEntries; i ++) {
                if(list[i].equals(anEntry)) {
                    
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void add(T newEntry) {
        // TODO Auto-generated method stub
        if(newEntry == null) {
            throw new IllegalArgumentException();
        }
        list[numberOfEntries] = newEntry;
        numberOfEntries ++;
        ensureCapacity();
    }

    private void ensureCapacity() {
        if (isFull()) {
            capacity *= 2;
            checkCapacity (capacity); // too big ?
            list = Arrays.copyOf(list, capacity);
        }
    }

    private boolean isFull() {
        return (numberOfEntries == capacity);
    }
}
