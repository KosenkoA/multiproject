package org.example;

// This is a shared test class. It may be used by spring-module-1.
// The main method is used to test if the class is accessible from spring-module-1
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}