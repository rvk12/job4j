package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestTaskChapter1Test {
    /**
     * @author rvk12.
     * check that result will contain values from both arrays and it is sorted.
     * */
    @Test
    public void whenJoinTwoSortedArraysResultShouldBeSorted() {
        TestTaskChapter1 finalArray = new TestTaskChapter1();
        int[] arrayFirst = {1, 3, 10};
        int[] arraySecond = {3, 12, 14, 19, 34};
        int[] expect = {1, 3, 3, 10, 12, 14, 19, 34};
        int[] result = finalArray.merge(arrayFirst, arraySecond);
        assertThat(result, is(expect));
    }
}