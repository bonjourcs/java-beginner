package com.bonjourcs.java.java8.function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);

    }

    @Test
    public void testFilterApples() {

        // filter green apple
        Assert.assertEquals(1,
                AppleUtils.filterApples(apples, AppleUtils::isGreenApple).size());
        AppleUtils.filterApples(apples, apple -> "Green".equalsIgnoreCase(apple.getColor()));

        // filter big apple
        Assert.assertEquals(3,
                AppleUtils.filterApples(apples, AppleUtils::isBigApple).size());
        AppleUtils.filterApples(apples, apple -> apple.getWeight() > 150);

    }

}