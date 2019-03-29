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
    public void whenJoinTwoSortedArraysSecondIsBiggerResultShouldBeSorted() {
        TestTaskChapter1 finalArray = new TestTaskChapter1();
        int[] arrayFirst = {1, 3, 10};
        int[] arraySecond = {3, 12, 14, 19, 34};
        int[] expect = {1, 3, 3, 10, 12, 14, 19, 34};
        int[] result = finalArray.merge(arrayFirst, arraySecond);
        assertThat(result, is(expect));
    }

    @Test
    public void whenJoinTwoSortedArraysFirstIsBiggerResultShouldBeSorted() {
        TestTaskChapter1 finalArray = new TestTaskChapter1();
        int[] arrayFirst = {1, 3, 10, 12, 23, 57, 90, 100, 700};
        int[] arraySecond = {3, 12, 14, 19, 34};
        int[] expect = {1, 3, 3, 10, 12, 12, 14, 19, 23, 34, 57, 90, 100, 700};
        int[] result = finalArray.merge(arrayFirst, arraySecond);
        assertThat(result, is(expect));
    }

    @Test
    public void whenJoinTwoEqualSortedArraysResultShouldBeSorted() {
        TestTaskChapter1 finalArray = new TestTaskChapter1();
        int[] arrayFirst = {3, 12, 14, 19, 34};
        int[] arraySecond = {3, 12, 14, 19, 34};
        int[] expect = {3, 3, 12, 12, 14, 14, 19, 19, 34, 34};
        int[] result = finalArray.merge(arrayFirst, arraySecond);
        assertThat(result, is(expect));
    }

    @Test
    public void whenJoinFirstEmptyArraySecondNotEmptySortedResultShouldBeSorted() {
        TestTaskChapter1 finalArray = new TestTaskChapter1();
        int[] arrayFirst = {};
        int[] arraySecond = {3, 12, 14, 19, 34};
        int[] expect = {3, 12, 14, 19, 34};
        int[] result = finalArray.merge(arrayFirst, arraySecond);
        assertThat(result, is(expect));
    }

    @Test
    public void whenJoinFirstNotEmptySortedArraySecondEmptyResultShouldBeSorted() {
        TestTaskChapter1 finalArray = new TestTaskChapter1();
        int[] arrayFirst = {3, 12, 14, 19, 34};
        int[] arraySecond = {};
        int[] expect = {3, 12, 14, 19, 34};
        int[] result = finalArray.merge(arrayFirst, arraySecond);
        assertThat(result, is(expect));
    }
}