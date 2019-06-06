package com.bonjourcs.java.ejc.concurrency.callable;

import com.bonjourcs.java.ejc.util.EvaluationUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * @author Liang Chenghao
 * Description: test for find max exucutor
 * Date: 2019/6/6
 */
public class FindMaxExecutorTest {

    private int[] arrays;

    /**
     * initialize a big array
     */
    @Before
    public void init() {
        arrays = IntStream.rangeClosed(1, 180_000_000).toArray();
    }

    @Test
    public void testFindMax() throws ExecutionException, InterruptedException {

        int max = FindMaxExecutor.findMax(arrays);
        Assert.assertEquals(180_000_000, max);

    }

    @Test
    public void testTimeInterval() {

        // multi-thread version
        long time1 = EvaluationUtils.evaluateTime(arrays, array -> {
            try {
                FindMaxExecutor.findMax(array);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // simple comparing version
        long time2 = EvaluationUtils.evaluateTime(arrays, this::findMax);

        Assert.assertTrue(time1 < time2);

    }

    public int findMax(int[] arrays) {

        if (arrays.length == 0) {
            throw new RuntimeException("array can not be empty");
        } else if (arrays.length == 1) {
            return arrays[0];
        }

        int max = arrays[0];
        for (int value : arrays) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

}
