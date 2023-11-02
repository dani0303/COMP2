package utils;

public class Nice {
    private String name;
    private AList<String> gifts;

    public Nice(String name) {
        this.name = name;
        this.gifts = new AList<>();
    }

    public String getName() {
        // TODO Auto-generated method stub
        return name;        
    }

    public void addGift(String gift) {
        // TODO Auto-generated method stub
        gifts.add(gift);
    }

    public Object[] getGifts() {
        // TODO Auto-generated method stub
        return gifts.toArray();
    }

    public int compareTo(Nice anEntry) {
        // TODO Auto-generated method stub
        return this.name.compareTo(anEntry.getName());
    }
}
