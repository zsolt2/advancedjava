package org.example.OpenClosed.BadPattern;

import org.example.OpenClosed.BadPattern.BigQuestion;

public class App {
    public static void main(String[] args) {
        System.out.println(new BigQuestion().get(42));
        System.out.println(new BigQuestion().get(34));
        System.out.println(new BigQuestion().get(43));
        System.out.println(new BigQuestion().get(-10));

        System.out.println(new BigQuestion().get(-51));
    }
}
