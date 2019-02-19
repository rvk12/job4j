package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest  {
    /**
     * Test addition.
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test subtracting.
     */
    @Test
    public void whenSubtractTwoFromThreeThenTwo()  {
        Calculator calc = new Calculator();
        calc.subtract(3D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test divide.
     */
    @Test
    public void whenDivideSixByTwoThenThree()  {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiply.
     */
    @Test
    public void whenMultiplySixByTwoThenTwelve()  {
        Calculator calc = new Calculator();
        calc.multiply(6D, 2D);
        double result = calc.getResult();
        double expected = 12D;
        assertThat(result, is(expected));
    }

}