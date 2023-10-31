package utils;

public class Llist <T> extends LinkedChainBase <T> implements ListInterface <T> {

    public Llist() {
        super();
    }
    public static void main(String[] args) {
        Llist <String> animals = new Llist<>();
        animals.add("tiger");
        animals.add("cat");
        animals.add("dog");
        animals.add("bidrd");
        animals.add("shark");

        Object[] words = animals.toArray();
        for(int i = 0; i < words.length; i ++) {
            System.out.println(words[i]);
        }
    }

    @Override
    public void add(T newEntry) {
        // TODO Auto-generated method stub
        int n = getLength();
        add(n, newEntry);
    }

    @Override
    public void add(int newPosition, T newEntry) {
        // TODO Auto-generated method stub
        Node <T> toAdd = new Node<>(newEntry);
        if(newPosition == 0) {
            addFirstNode(toAdd);
        }
        else {
            Node <T> before = getNodeAt(newPosition - 1);
            addNodeAfter(before, toAdd);
        }
    }

    @Override
    public boolean remove(T anEntry) {
        // TODO Auto-generated method stub
        Node <T> prevNode = null;
        Node <T> curNode = getFirsNode();

        while(curNode != null) {
            if(anEntry.equals(curNode.getData())) {
                break;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }

        if(curNode == null) {
            return false;
        }

        if(prevNode == null) {
            removeFirstNode();
        }
        else {
            removNodeAfter(prevNode);
        }
        return true;
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        // TODO Auto-generated method stub
        if(givenPosition < 0 || givenPosition >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        Node <T> theNode = getNodeAt(givenPosition);
        T oldValue = theNode.getData();
        theNode.setData(newEntry);
        return oldValue;
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        for(Node <T> curr = getFirsNode(); curr != null; curr = curr.getNext()) {
            if(anEntry.equals(curr.getData())) {
                return true;
            }
        }
        return false;
    }
}
