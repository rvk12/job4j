package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {

    /**
     * checks line is created by words from origin
     */
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Set<String> originSet = new HashSet<>(Arrays.asList(origin.split("\\P{L}+")));
        String[] lineSplit = line.split("\\P{L}+");
        for (String word : lineSplit) {
            if (!originSet.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}