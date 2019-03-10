package ru.job4j.array;


import java.util.Arrays;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {

    /**
     * Sorts elements in array ascending
     *
     * @param array array with elements which should be sorted.
     * @return sorted array
     */
    public int[] sort(int[] array) {
        int i, j, temp;
        for (i = 1; i < array.length; i++) {
            for (j = 1; j <= array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
}





