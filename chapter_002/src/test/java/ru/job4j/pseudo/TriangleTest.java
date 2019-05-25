package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author rvk12
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawTriabgle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("    +")
                                .append(System.getProperty("line.separator"))
                                .append("   +++")
                                .append(System.getProperty("line.separator"))
                                .append("  +++++")
                                .append(System.getProperty("line.separator"))
                                .append(" +++++++")
                                .append(System.getProperty("line.separator"))
                                .append("+++++++++")
                                .toString()
                )
        );
    }
}