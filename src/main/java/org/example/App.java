package org.example;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyList<String> myList = null;
        System.out.println("Enter minimum 10 elements");
        String[] strings = new String[10];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
        try {
            myList = new MyList<>(strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(myList.get(5));
        System.out.println(myList.remove(5));

        System.out.println(myList);
        System.out.println(myList.size());
    }
}
