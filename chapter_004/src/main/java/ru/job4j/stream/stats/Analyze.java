package ru.job4j.stream.stats;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .mapToInt(num -> num.getScore()).average().orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                .mapToInt(num -> num.getScore()).average().orElse(0))
        ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(p -> new Tuple(p.getKey(), p.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects().stream().mapToDouble(d -> d.getScore()).sum()))
                .max(Comparator.comparing(p -> p.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(p -> new Tuple(p.getKey(), p.getValue()))
                .max(Comparator.comparing(p -> p.getScore()))
                .orElse(null);
    }
}