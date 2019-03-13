package ru.job4j.array;

import java.util.Arrays;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {

    /**
     * Removes duplicates in array.
     *
     * @param array array in which should be checked duplicates.
     * @return array with removed duplicates.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}