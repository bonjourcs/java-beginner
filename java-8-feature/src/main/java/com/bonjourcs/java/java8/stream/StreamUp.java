package com.bonjourcs.java.java8.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: Stream up and running
 * Date: 2018/12/24
 */
public class StreamUp {

    public static <T> void consumeStream(Stream<T> stream, Consumer<T> consumer) {
        stream.forEach(consumer);
    }

    public static <T> List<T> filterUnique(List<T> list, Predicate<T> predicate) {

        return list.stream()
                .filter(predicate)
                .distinct()
                .collect(Collectors.toList());

    }

    /**
     * takeWhile method in java 8
     *
     * @param list      list to take
     * @param predicate predicate
     * @param <A>       element type
     * @return result list
     */
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> predicate) {

        int i = 0;

        for (A item : list) {
            if (!predicate.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }

        return list;
    }

}
