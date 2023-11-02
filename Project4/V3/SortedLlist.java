package utils;

public class SortedLlist < T extends Comparable <? super T>> implements SortedListInterface <T> {
    private ListInterface<T> list;

    public SortedLlist() {
        list = new Llist<>();
    }

    public void addEntry(T entry) {
        int newPosition = Math.abs(getPosition(entry) + 1);
        list.add(newPosition, entry);
    }

    public boolean removeEntry(T anEntry) {
        int position = getPosition(anEntry);
        if(position >= 0) {
            list.remove(position);
            return true;
        }
        return false;
    }

    public int getPosition(T anEntry) {
        int position = 0;
        int compValue = 0;
        int length = list.getLength();
        while(position < length) {
            compValue = anEntry.compareTo(list.getEntry(position));
            if(compValue <= 0) {
                break;
            }
            position ++;
        }
        if(position == length || compValue < 0) {
            position = -1 - position;
        }
        return position;
    }

    public T getEntry(int givenPosition) {
        return list.getEntry(givenPosition);
    }

    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    public T remove(int givenPosition) {
        return list.remove(givenPosition);
    }

    public void clear() {
        list.clear();
    }

    public int getLength() {
        return list.getLength();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object[] toArray() {
        return list.toArray();
    }

}
