package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class CheckTest {

    /**
     * When all elements contain true and array contains odd amount of elements
     * then it should return true.
     */
    @Test
    public void whenDataMonoByTrueOddAmountThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * When some elements contain true and some false and array contains odd amount of elements
     * then it should return false.
     */
    @Test
    public void whenDataNotMonoByTrueOddAmountThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * When some elements contain true and some false and array contains even amount of elements
     * then it should return false.
     */
    @Test
    public void whenDataNotMonoByTrueEvenAmountAmountThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * When all elements contain false and array contains even amount of elements
     * then it should return false.
     */
    @Test
    public void whenDataMonoByFalseEvenAmountThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

}