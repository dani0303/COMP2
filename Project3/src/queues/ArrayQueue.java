package queues;

public class ArrayQueue<T> {
    private T[] queuearr;
    // how to handle front and back?
    private int frontIndex;
    private int backIndex;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue(int capacity) {
        T[] temp = (T[]) new Object [capacity];
        queuearr = temp;
        this.capacity = capacity;
        frontIndex = 0;
        backIndex = capacity - 1;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);        
    }
}
