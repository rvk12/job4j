package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size1 = left.length();
        int size2 = right.length();
        int limit = Math.min(size1, size2);
        for (int i = 0; i < limit; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return size1 - size2;
    }
}