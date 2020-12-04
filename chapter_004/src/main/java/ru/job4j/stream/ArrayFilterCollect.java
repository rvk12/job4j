package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFilterCollect {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(242, -5, 1, 14, -7, 1029);
        List<Integer> positive = nums.stream().filter(
                num -> num > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }

}
