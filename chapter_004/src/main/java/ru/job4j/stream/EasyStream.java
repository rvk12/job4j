package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> out;

    private EasyStream(List<Integer> source) {
        out = source;
    }

    public static EasyStream of(List<Integer> source)
    {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer cur : out) {
            tmp.add(fun.apply(cur));
        }
        out = tmp;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer cur : out) {
            if (fun.test(cur)) {
                tmp.add(cur);
            }
        }
        out = tmp;
        return this;
    }

    public List<Integer> collect() {
        return out;
    }

}