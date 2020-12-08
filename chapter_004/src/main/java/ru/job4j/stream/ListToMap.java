package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convertStudent(List<Student> students) {
        return students.stream().collect(Collectors
                .toMap(k -> k.getSurname(), v -> v, (o1, o2) -> o1));
    }

}
