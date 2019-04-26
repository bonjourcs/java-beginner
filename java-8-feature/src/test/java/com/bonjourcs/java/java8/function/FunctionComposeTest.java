package com.bonjourcs.java.java8.function;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/4/26
 */
public class FunctionComposeTest {

    @Test
    public void andCompose() {

        int value = FunctionCompose.andCompose((Integer x) -> x + 1, y -> y << 2).apply(10);
        Assert.assertEquals(44, value);

}

    @Test
    public void testCompose() {

        int value = FunctionCompose.compose(x -> x + 1, (Integer y) -> y << 2).apply(10);
        Assert.assertEquals(41, value);

    }

}
