package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstGreaterSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 3);
        assertThat(result, is(5));
    }

    /**
     * Тест сравнивания трех чисел
     * */
    @Test
    public void whenThirdGreaterThanFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 3, 8);
        assertThat(result, is(8));
    }

    /**
     * Тест сравнивания трех чисел
     * */
    @Test
    public void whenFirstGreaterThanThirdAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(7, 3, 5);
        assertThat(result, is(7));
    }

    /**
     * Тест сравнивания трех чисел
     * */
    @Test
    public void whenSecondGreaterThanFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(7, 9, 5);
        assertThat(result, is(9));
    }

}