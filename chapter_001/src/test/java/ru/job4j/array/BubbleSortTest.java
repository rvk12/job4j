package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {

    /**
     * Test bubble sort
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = new BubbleSort().sort(input);
        int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
    }
}