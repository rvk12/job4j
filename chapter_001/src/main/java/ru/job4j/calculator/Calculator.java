package ru.job4j.calculator;

/**
 * Class used for calculating values
 *
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class Calculator {

    private double result;

    /**
     * Method add is used to sum 2 values.
     *
     * @param first  first value.
     * @param second second value.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract is used to subtract of one value from another.
     *
     * @param first  first value.
     * @param second second value.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method subtract is used to divide one value by another.
     *
     * @param first  first value.
     * @param second second value.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method subtract is used to multiply one value by another.
     *
     * @param first  first value.
     * @param second second value.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult prints result of calculation
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}