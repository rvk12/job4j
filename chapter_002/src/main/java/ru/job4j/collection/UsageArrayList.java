package ru.job4j.collection;


import java.util.ArrayList;

public class UsageArrayList {

    /**
     * Creates new ArrayList of type String
     * Adds 3 names in List
     * Prints all the values from list
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (Object value : names) {
            System.out.println(value);
        }
    }
}
