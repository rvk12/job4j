package ru.job4j.array;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Calculates square of numbers from 1 to bound.
     *
     * @param bound number in array on which calculation should be stopped.
     * @return array.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = (i) * (i);
        }
        return rst;
    }
}