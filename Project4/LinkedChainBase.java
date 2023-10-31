package utils;

import utils.Node;

abstract class LinkedChainBase <T>{
    private Node <T> head;
    private int numberOfEntries;

    protected LinkedChainBase() {
        initializeDataFields();
    }

    private void initializeDataFields() {
        head = null;
        numberOfEntries = 0;
    }

    protected Node <T> getFirsNode() {
        return head;
    }

    protected Node <T> getNodeAt(int givenPosition) {
        if(givenPosition < 0 || givenPosition >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Wrong position");
        }
        Node <T> curr = head;
        for(int i = 0; i < givenPosition; i ++) {
            curr = curr.getNext();
        }
        return curr;
    }

    protected Node <T> removeFirstNode() {
        Node <T> toRemove = head;
        head = head.getNext();
        numberOfEntries --;
        return toRemove;
    }

    protected Node <T> removNodeAfter(Node <T> aNode) {
        Node <T> nextNode = aNode.getNext();
        /*
         * if(nextNode == null) {
            return null;
        }
        
        Node <T> nextNext = nextNode.getNext();
        aNode.setNext(nextNext);
        numberOfEntries --;
        return nextNode;
         */
        if(nextNode != null) {
            aNode.setNext(nextNode.getNext());
            numberOfEntries --;
        }
        return nextNode;
    }

    protected void addFirstNode(Node <T> toAdd) {
        toAdd.setNext(head);
        head = toAdd;
        numberOfEntries ++;
    }

    protected void addNodeAfter(Node <T> prevNode, Node <T> toAdd) {
        toAdd.setNext(prevNode.getNext());
        prevNode.setNext(toAdd);
        numberOfEntries ++;
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        if(numberOfEntries == 0 ^ head == null) {
            throw new IllegalStateException("corrupted chain");
        }

        return numberOfEntries == 0;
    }

    public void clear() {
        initializeDataFields();
    }

    public T getEntry(int givenPosition) {
        return getNodeAt(givenPosition).getData();
    }

    public T remove(int givenPosition) {
        if(givenPosition < 0 || givenPosition >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Wrong position");
        }
        if(givenPosition == 0) {
            return removeFirstNode().getData();
        }
        Node <T> prevNode = getNodeAt(givenPosition);
        return removNodeAfter(prevNode).getData();
    }

    public Object[] toArray() {
        Object[] result = new Object[numberOfEntries];
        int idx = 0;
        for(Node <T> curr = head; curr != null; curr = curr.getNext()) {
            result[idx ++] = curr.getData();
        }

        return result;
    }
}
