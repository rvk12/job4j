package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {

    /**
     * Проверяет результат вычисления площади треугольника по трем заданным точкам
     * при условии что треугольник по этим точкам можно построить
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Если треугольник нельзя построить, то площадь нельзя посчитать
     */
    @Test
    public void whenPointsAreOnOneLineThenNotPossibleToCalculateArea() {
        Point a = new Point(0, 3);
        Point b = new Point(0, 4);
        Point c = new Point(0, 8);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1D;
        assertThat(result, closeTo(expected, 0.1));
    }

}