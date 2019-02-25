package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }

    @Test
    public void whenSumEvenNumbersFromTwoToEightThenThirty() {
        Counter count = new Counter();
        int result = count.add(2, 8);
        assertThat(result, is(20));
    }

    @Test
    public void whenSumEvenNumbersFromSevenToThirteenThenThirty() {
        Counter count = new Counter();
        int result = count.add(7, 13);
        assertThat(result, is(30));
    }

}