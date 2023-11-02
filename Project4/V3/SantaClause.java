package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class SantaClause {
    private static SortedAList niceList;
    private static AList naughtyList;

    public static void main(String[] args) {
        SantaClause santaClause = new SantaClause();
        AList people = new AList<String>();
        try {
            File myFile = new File("C:\\Users\\rodriguezd14\\eclipse-workspace\\Project4\\src\\utils\\people.txt");
            Scanner myScanner = new Scanner(myFile);
            while(myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                people.add(data);
            }
            myScanner.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }

        //Begin splitting process
        Object[] arr = people.toArray();
        for(int i = 0; i < arr.length; i ++) {
            String str = arr[i].toString();
            String[] splitted = str.split("  ");

            //If the splitted string only has a name that means that they don't have a gift and are on the naughty list
            if(splitted.length == 1) {
                santaClause.addNaughtyPerson(str);
            }
        }

        Object[] arrTest = santaClause.getNaughtyList();
        for(int i = 0; i < arrTest.length; i ++) {
            System.out.println(arrTest[i]);
        }
    }

    public void addNicePerson(String name) {
        Nice entry = new Nice(name);
        niceList.addEntry(name);
    }

    public void addNaughtyPerson(String name) {
        naughtyList.add(name);
    }

    public SantaClause() {
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
