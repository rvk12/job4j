package ru.job4j.array;

/**
 * @author rvk12.
 * @since 0.1
 */
public class TestTaskChapter1 {

    /**
     * @param left  first sorted array.
     * @param right second sorted array.
     * @return sorted array which contains elements from first and second arrays.
     * @author rvk12.
     */
    int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int firstArrIndex = 0;
        int secondArrIndex = 0;
        for (int i = 0; i < merged.length; i++) {
            if (firstArrIndex >= left.length) {
                merged[i] = right[secondArrIndex];
                secondArrIndex++;
            } else if (secondArrIndex >= right.length) {
                merged[i] = left[firstArrIndex];
                firstArrIndex++;
            } else if (left[firstArrIndex] < right[secondArrIndex]) {
                merged[i] = left[firstArrIndex];
                firstArrIndex++;
            } else {
                merged[i] = right[secondArrIndex];
                secondArrIndex++;
            }
        }

        return merged;
    }
}