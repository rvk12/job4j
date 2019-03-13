package ru.job4j.array;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {

    /**
     * Check if each diagonal contains equal boolean values.
     * There are checked 2 central diagonals.
     *
     * @param data matrix array with true/false values.
     * @return true if elements are equal and false if not
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != data[0][0]) {
                result = false;
                break;
            }
            if (data[i][data.length - 1 - i] != data[0][data.length - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}