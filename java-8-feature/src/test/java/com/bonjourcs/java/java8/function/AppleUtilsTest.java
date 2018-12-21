package com.bonjourcs.java.java8.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/12/14
 */
public class AppleUtilsTest {

    private List<Apple> apples;

    @Before
    public void init() {

        apples = new ArrayList<>();

        Apple apple1 = new Apple("Green", 100);
        Apple apple2 = new Apple("Yellow", 160);
        Apple apple3 = new Apple("Blue", 170);
        Apple apple4 = new Apple("Pink", 180);
        Apple apple5 = new Apple("Green", 180);

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);

    }

    @Test
    public void testFilterApples() {

        // filter green apple
        Assert.assertEquals(2,
                AppleUtils.filterApples(apples, AppleUtils::isGreenApple).size());
        AppleUtils.filterApples(apples, apple -> "Green".equalsIgnoreCase(apple.getColor()));

        // filter big apple
        Assert.assertEquals(4,
                AppleUtils.filterApples(apples, AppleUtils::isBigApple).size());
        AppleUtils.filterApples(apples, apple -> apple.getWeight() > 150);

    }

    @Test
    public void testFilterAppleByFruitUtils() {

        Assert.assertEquals(1,
                FruitUtils.filterFruit(apples, apple ->
                        "Green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150
                ).size());

    }

    @Test
    public void testFilterAndReturn() {

        List<Apple> newApples = FruitUtils.filterAndReturn(apples,
                this::filterApple);

        Assert.assertEquals(4, newApples.size());
    }

    private Apple filterApple(Apple apple) {

        if (apple.getWeight() > 150) {
            return apple;
        }

        return null;
    }

    @Test
    public void testConsumeFruit() {

        // filter apples
        List<Apple> newApples
                = FruitUtils.filterFruit(apples, apple -> "Green".equalsIgnoreCase(apple.getColor()));

        // consume apples
        FruitUtils.consumeFruit(
                newApples
                , System.out::println);

    }

    @Test
    public void testLambda() {
        doSomething(1, 2, (a, b) -> System.out.println("a=" + a + "b=" + b));
    }

    /**
     * this is where you call Helper class
     *
     * @param a      integer a
     * @param b      integer b
     * @param helper Helper class instance
     */
    private void doSomething(int a, int b, Helper helper) {

        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.run();

        helper.help(a, b);
    }

    interface Helper {
        void help(int a, int b);
    }


    @Test
    public void testGetApple() {
        Assert.assertEquals(10, getApple("Yellow", 10).getWeight());
    }

    static Map<String, Function<Integer, Apple>> map = new HashMap<>();

    static {
        map.put("Green", Apple::new);
        map.put("Yellow", Apple::new);
    }

    private static Apple getApple(String color, int weight) {
        return map.get(color).apply(weight);
    }

    @Test
    public void testFunctionalInterface() {

        TirFunction<String, String, String, RGB> color = RGB::new;
        Assert.assertNotNull(color.apply("100", "100", "100"));

    }

    /**
     * color rgb
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class RGB {

        private String red;

        private String green;

        private String blue;

    }

    @FunctionalInterface
    private interface TirFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }

    @Test
    public void testSortApple() {

        apples.sort(Comparator.comparing(Apple::getWeight).reversed()
        .thenComparing(Apple::getColor));

    }
}