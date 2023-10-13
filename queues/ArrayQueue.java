package queues;

import java.util.EmptyStackException;

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queuearr;
    // how to handle front and back?
    private int frontIndex;
    private int backIndex;
    private int capacity;
    private boolean integrityOk;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100;

    public ArrayQueue(int capacity) {
        T[] temp = (T[]) new Object [capacity - 1];
        queuearr = temp;
        this.capacity = capacity; 
        frontIndex = 0;
        backIndex = capacity;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);        
    }

    private void ensureCapacity() {
        T[] oldQueue = queuearr;
        T[] temparray = (T[]) new Object[2*capacity];
        int index;
        for(index = 0; index < oldQueue.length; index++) {
            temparray[index] = oldQueue[(frontIndex + backIndex)%capacity];
        }
        frontIndex = 0;
        backIndex = capacity - 2;
        queuearr = temparray;
    }

    private boolean isFull() {
        return(frontIndex == (backIndex + 2)%capacity);
    }

    /*
    * Adds an element to the back of the queue
    * @param newEntry
    */
    public void enqueue (T newEntry) {
        backIndex = (backIndex + 1) % capacity;
        queuearr[backIndex] = newEntry;
        if(isFull()) {
            ensureCapacity();
        }
        printQueues();
    }

    /**
    * Removes the element from the front of the queue.
    * Throws EmptyQueueException if the queue is empty
    * @return the removed entry
    */
    public T dequeue () {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T front = queuearr[frontIndex];
        queuearr[frontIndex] = null;
        frontIndex = (frontIndex + 1) % capacity;
        if(isEmpty()) {
            frontIndex = 0;
            if(capacity > DEFAULT_CAPACITY) {
                capacity = DEFAULT_CAPACITY;
            }
            queuearr = (T[]) new Object [capacity];
            backIndex = capacity - 1;
        }
        return front;
    }

    /**
    * Retrieves the element from the front of the queue.
    * Throws EmptyQueueException if the queue is empty
    * @return the front entry
    */
    public T getFront() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return queuearr[frontIndex];
    }

    /**
    * removes all entries from the queue
    */
    public void clear() {
        queuearr = (T[]) new Object [capacity];
        frontIndex = 0;
        backIndex = capacity - 1;
    }

    /**
    * detects whether the queue is empty
    * @return true or false
    */
    public boolean isEmpty() {
        return frontIndex == (backIndex + 1)%capacity;
    }

    public void printQueues() {
        for(int i = 0; i < queuearr.length; i++) {
            System.out.println(queuearr[i]);
        }
    }
}