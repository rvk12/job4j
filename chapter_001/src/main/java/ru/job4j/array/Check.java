package ru.job4j.array;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class Check {

    /**
     * Compares all values are equal or not
     *
     * @param data array with values which should be compared.
     * @return true if all equal or false if not
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 1; index < data.length; index++) {
            if (data[index - 1] == data[index]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
