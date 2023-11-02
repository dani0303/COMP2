package utils;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileTest {
    public static void main(String[] args) {
        try {
            File myFile = new File("C:\\Users\\rodriguezd14\\eclipse-workspace\\Project4\\src\\utils\\file.txt");
            Scanner myScanner = new Scanner(myFile);
            while(myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                System.out.println(data);
            }
            myScanner.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}
