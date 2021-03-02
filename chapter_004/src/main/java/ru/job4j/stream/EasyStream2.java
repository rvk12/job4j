package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream2 {
    private List<Integer> out;

    public static EasyStream2 of(List<Integer> source)
    {
        return new BuiltStream(source).build();
    }

    public EasyStream2 map(Function<Integer, Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer cur : out) {
            tmp.add(fun.apply(cur));
        }
        out = tmp;
        return this;
    }

    public EasyStream2 filter(Predicate<Integer> fun) {
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

    private static class BuiltStream {
        private List<Integer> buildOut;
        private BuiltStream(List<Integer> source) {
            buildOut = source;
        }

        public EasyStream2 build() {
            return new EasyStream2(this);
        }
    }

    private EasyStream2(BuiltStream bs) {
        out = bs.buildOut;
    }

}