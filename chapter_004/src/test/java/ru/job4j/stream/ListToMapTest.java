package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ListToMapTest {

    @Test
    public void whenListAsInputThenResultIsMap() {
        Map<String, Student> expectedMap = new TreeMap<>() {{
            put("Surname1", new Student(10, "Surname1"));
            put("Surname2", new Student(20, "Surname2"));
            put("Surname3", new Student(30, "Surname3"));
            put("Surname4", new Student(40, "Surname4"));
            put("Surname5", new Student(50, "Surname5"));
            put("Surname6", new Student(60, "Surname6"));
            put("Surname7", new Student(70, "Surname7"));
            put("Surname8", new Student(80, "Surname8"));
            put("Surname9", new Student(90, "Surname9"));
        }};
        List<Student> students = Arrays.asList(new Student(10, "Surname1")
                , new Student(20, "Surname2"), new Student(30, "Surname3")
                , new Student(40, "Surname4"), new Student(50, "Surname5")
                , new Student(60, "Surname6"), new Student(70, "Surname7")
                , new Student(80, "Surname8"), new Student(90, "Surname9")
                , new Student(10, "Surname1"));
        Map<String, Student> studentsMap = ListToMap.convertStudent(students);
        assertThat(studentsMap, is(expectedMap));
    }
}
