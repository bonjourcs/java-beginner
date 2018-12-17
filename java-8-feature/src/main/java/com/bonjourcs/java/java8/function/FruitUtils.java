package com.bonjourcs.java.java8.function;

import java.util.ArrayList;
import java.util.List;
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
}
