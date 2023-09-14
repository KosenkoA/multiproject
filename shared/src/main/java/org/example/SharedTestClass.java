package org.example;

public class SharedTestClass {
    // This is a shared test class. It is used by spring-module-1.
    // The main method is used to test if the class is accessible from spring-module-1
    public static void helloWorld(String[] args) {
        System.out.print("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}
