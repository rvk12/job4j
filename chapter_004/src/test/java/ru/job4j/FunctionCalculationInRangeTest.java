package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionCalculationInRangeTest {

    FunctionCalculationInRange function = new FunctionCalculationInRange();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = function.diapason(5, 8, x -> x * x - 2 * x + 1);
        List<Double> expected = Arrays.asList(16D, 25D, 36D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = function.diapason(2, 6, x -> pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}
