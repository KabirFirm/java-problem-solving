package com.egeneration;

import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("BMW");
        cars.add("Volvo");
        cars.add("Mazda");
        cars.add("Ford");
        System.out.println(cars);
        System.out.println(cars.getFirst());
    }
}
