package ru.job4j.array;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {

    /**
     * Finds index of element in array.
     *
     * @param data array of numbers
     * @param el   value to search
     * @return index of found element
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}