package com.example.springmodule1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringModule1Application {
    // This is the main class for the Spring Module 1 application
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(SpringModule1Application.class, args);
    }

}
