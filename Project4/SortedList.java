package utils;

public class SortedList <T extends Comparable <? super T>> extends LinkedChainBase <T> implements SortedListInterface <T> {

    @Override
    public void addEntry(T newEntry) {
        // TODO Auto-generated method stub
        int pos = getPosition(newEntry);
        if(pos < 0) {
            pos = -pos - 1;
        }
        Node <T> toAdd = new Node <>(newEntry);
        if(pos == 0) {
            addFirstNode(toAdd);
        }
        else {
            Node <T> before = getNodeAt(pos - 1);
            addNodeAfter(before, toAdd);
        }
    }

    @Override
    public boolean removeEntry(T anEntry) {
        // TODO Auto-generated method stub
        int pos = getPosition(anEntry);
        if(pos < 0) {
            return false;
        }
        if(pos == 0) {
            removeFirstNode();
        }
        else {
            Node <T> prevNode = getNodeAt(pos - 1);
            removNodeAfter(prevNode);
        }
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        // TODO Auto-generated method stub
        int pos = 0;
        Node <T> curr = getFirsNode();
        int comp;
        while(curr != null) {
            comp = anEntry.compareTo(curr.getData());
            if(comp == 0) {
                return pos;
            }
            if(comp < 0) {
                return -pos - 1;
            }
            curr = curr.getNext();
            pos ++;
        }
        return pos;
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        return getPosition(anEntry) >= 0;
    }
    
}
