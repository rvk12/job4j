package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test calculating distance between two points
 */
public class PointTest {
    /**
     * Check distance when x1 = 0, y1 = 1, x2 = 2, y2 = 5.
     */
    @Test
    public void whenX1Equal1Y1Equal1X2Equal2Y2Equal5ThenDistance4Dot47() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(4.47, 0.01));
    }


}