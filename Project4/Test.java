package utils;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr.length);
        int[] temp = new int[0];
        arr = temp;
        System.out.println(arr.length);
    }
}
