package queues;

class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
        super();
    }
    
    public EmptyQueueException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}

public class LinkedQueue <T> implements QueueInterface <T> {
    private Node <T> frontNode;
    private Node <T> backNode;

    public LinkedQueue () {
        frontNode = null;
        backNode = null;
    }

    public void enqueue (T newEntry) {
        Node <T> newNode = new Node <> (newEntry);
        if (isEmpty())
            frontNode = newNode;

        else
            backNode.setNext(newNode);
            backNode = newNode;
    }

    public T getFront(){
        if (isEmpty())
            throw new EmptyQueueException();
        return frontNode.getData();
    }

    public T dequeue () {
        if (isEmpty())
            throw new EmptyQueueException();
        T front = frontNode.getData();
        frontNode = frontNode.getNext();
        if(frontNode == null)
            backNode = null;
        return front;
    }

    public boolean isEmpty() {
        return (frontNode == null) && (backNode == null);
    }

    public void clear() {
        frontNode = null;
        backNode = null;
    }
}
