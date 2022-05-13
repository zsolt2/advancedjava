package org.example;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Map<String, Integer> col = new HashMap<>();
        col.containsValue(1);

        // Object tipusra nem jo hasznalni
        List<Object> lista = new ArrayList<>();

        lista.add("hello");
        lista.add(1);

        // Inkabb hozzuk letre interfacere
        List<Item> itemList = new ArrayList<>();


        List<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("cherry");
        System.out.println("fruits[2] = " + fruits.get(2));
        fruits.set(1, "grape");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Mivel string ezeret meg lehet siman hivni sort metodust
        Collections.sort(fruits);
        System.out.println("Sorted:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
