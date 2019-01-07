package com.bonjourcs.java.java8.reduce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/1/7
 */
public class ReduceUtilsTest {

    private List<Integer> integers;

    @Before
    public void init() {
        integers = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 2, 1);
    }

    @Test
    public void findMax() {
        assertEquals(5, (int) ReduceUtils.findMax(integers.stream()).get());
    }

}