package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import  java.util.Scanner;

public class Test {
    private static SortedLlist niceList;
    private static Llist naughtyList;

    public static void main(String[] args) {
        System.out.println("Nice: ");
        SantaClause santa = new SantaClause();
        Name person1 = new Name("Daniel", "Rodriguez");
        Name person2 = new Name("Jackson", "Morrow");
        Name person3 = new Name("Wyatt", "Rose");
        Name person4 = new Name("Nick", "Pacheco");
        Name person5 = new Name("Daniel A.", "Chavez");
        Name person6 = new Name("Adrian", "Aguire");

        String[] gifts = {"sim-wheel", "desk", "shoes"};
        //Asume they are nice
        Nice nicePerson1 = new Nice(person1.getFirstName());
        santa.addNicePerson(nicePerson1.getName());

        Nice nicePerson2 = new Nice(person2.getFirstName());
        santa.addNicePerson(nicePerson2.getName());

        Nice nicePerson3 = new Nice(person3.getFirstName());
        santa.addNicePerson(nicePerson3.getName());

        for(int i = 0; i < gifts.length; i ++) {
            nicePerson1.addGift(gifts[i]);
            nicePerson2.addGift(gifts[i]);
            nicePerson3.addGift(gifts[i]);
        }
        //Print nice list
        Object[] arr = santa.getNiceList();
        for(int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }

        /*
        //Gets gifts for person1
        Object[] giftsArray = nicePerson1.getGifts();
        for(int i = 0; i < giftsArray.length; i ++) {
            System.out.println(giftsArray[i]);
        }
        */

        System.out.println();

        //Asume people are naughty
        System.out.println("Naughty:  ");
        santa.addNaughtyPerson(person4.getFirstName());
        santa.addNaughtyPerson(person5.getFirstName());
        santa.addNaughtyPerson(person6.getFirstName());
        Object[] arr2 = santa.getNaughtyList();
        for(int i = 0; i < arr2.length; i ++) {
            System.out.println(arr2[i]);
        }
    }

    public void addNicePerson(String name) {
        Nice entry = new Nice(name);
        niceList.addEntry(name);
    }

    public void addNaughtyPerson(String name) {
        naughtyList.add(name);
    }

    public Test() {
        niceList = new SortedLlist<String>(); 
        naughtyList = new Llist<String>();
    }

    public Object[] getNiceList() {
        return niceList.toArray();
    }

    public Object[] getNaughtyList() {
        return naughtyList.toArray();
    }
}
