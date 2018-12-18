package com.bonjourcs.java.java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Liang Chenghao
 * Description: util class to filter fruit
 * Date: 2018/12/17
 */
public class FruitUtils {

    /**
     * filter any type of fruit
     *
     * @param fruits    fruits to filter
     * @param predicate predicate
     * @param <T>       type
     * @return filtered fruits
     */
    public static <T> List<T> filterFruit(List<T> fruits, Predicate<T> predicate) {

        List<T> newFruits = new ArrayList<>();

        fruits.forEach(f -> {
            if (predicate.test(f)) {
                newFruits.add(f);
            }
        });

        return newFruits;

    }

    /**
     * consume fruits
     *
     * @param fruits   fruits to operate
     * @param consumer consume method
     * @param <T>      fruit type
     */
    public static <T> void consumeFruit(List<T> fruits, Consumer<T> consumer) {
        fruits.forEach(consumer);
    }

    /**
     * filter and return
     *
     * @param fruits   fruits to filter
     * @param function function to filter
     * @param <T>      fruits type
     * @param <R>      return type
     * @return a list
     */
    public static <T, R> List<R> filterAndReturn(List<T> fruits, Function<T, R> function) {

        List<R> result = new ArrayList<>();

        fruits.forEach(f -> {
            R filter = function.apply(f);
            if (filter != null) {
                result.add(filter);
            }
        });

        return result;

    }
}
