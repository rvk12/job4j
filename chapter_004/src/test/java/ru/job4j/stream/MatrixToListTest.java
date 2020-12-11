package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

public class MatrixToListTest {

    @Test
    public void whenMatrixThenListIsReturned() {
        List<Integer> listExpected = List.of(1, 2, 5, 8, 9, 10);
        Integer[][] matrix = {{1, 2, 5}, {8, 9, 10}};
        List<Integer> result = MatrixToList.convert(matrix);
        assertThat(result, is(listExpected));
    }
}
