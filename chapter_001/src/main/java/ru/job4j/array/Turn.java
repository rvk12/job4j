package ru.job4j.array;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class Turn {

    /**
     * Changes position of values in array
     *
     * @param array array with values which should be relocated.
     * @return relocated array
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[array.length - index - 1];
            array[array.length - index - 1] = array[index];
            array[index] = temp;
        }
        return array;
    }
}