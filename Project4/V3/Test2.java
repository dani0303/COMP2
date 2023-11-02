package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    private static SortedAList niceList;
    private static AList naughtyList;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name followed by what you want for christmas. If you are naughty don't add a gift: ");
        String str = input.nextLine();
        AList people = new AList<>();


        //Split name and gift
        String[] arr = str.split("  ");
        if(arr.length == 1) {
            System.out.println("no gift");
        }
        for(int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }
    }

    public void addNicePerson(String name) {
        Nice entry = new Nice(name);
        niceList.addEntry(name);
    }

    public void addNaughtyPerson(String name) {
        naughtyList.add(name);
    }

    public Test2() {
        niceList = new SortedAList<String>(); 
        naughtyList = new AList<String>();
    }

    public Object[] getNiceList() {
        return niceList.toArray();
    }

    public Object[] getNaughtyList() {
        return naughtyList.toArray();
    }
}
