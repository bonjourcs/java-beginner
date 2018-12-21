package com.bonjourcs.java.java8.function;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Liang Chenghao
 * Description: class to operate apple
 * Date: 2018/12/14
 */
public class AppleUtils {

    /**
     * filter apple by dynamic criteria
     *
     * @param apple     apple to filter
     * @param predicate predicate
     * @return filtered apples
     */
    public static List<Apple> filterApples(List<Apple> apple, Predicate<Apple> predicate) {
        return FruitUtils.filterFruit(apple, predicate);
    }

    /**
     * filter green apple
     *
     * @param apple an apple
     * @return apple is green
     */
    public static boolean isGreenApple(Apple apple) {
        return "Green".equalsIgnoreCase(apple.getColor());
    }

    /**
     * filter big apple(weight is greater than 150)
     *
     * @param apple an apple
     * @return apple is weight than 150
     */
    public static boolean isBigApple(Apple apple) {
        return apple.getWeight() > 150;
    }

}
