package com.bonjourcs.java.java8.parallel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/3/15
 */
public class ParallelUtilsTest {

    private ParallelUtils parallelUtils;

    @Before
    public void init() {
        parallelUtils = new ParallelUtils();
    }

    @Test
    public void sum() {

        long start = System.currentTimeMillis();
        parallelUtils.sum(1_000_000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        ----------------
        start = System.currentTimeMillis();
        parallelUtils.parallelSum(1_000_000);
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    public void parallelSum() {

    }
}