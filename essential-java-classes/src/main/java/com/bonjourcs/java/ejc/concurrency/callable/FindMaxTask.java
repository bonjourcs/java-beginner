package com.bonjourcs.java.ejc.concurrency.callable;

import java.util.concurrent.Callable;

/**
 * @author Liang Chenghao
 * Description: a callable class to get max value from given array
 * Date: 2019/6/6
 */
public class FindMaxTask implements Callable<Integer> {

    private int[] array;
    private int start;
    private int end;

    public FindMaxTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * simple comparing algorithm
     *
     * @return max value in array
     */
    @Override
    public Integer call() {

        int max = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;

    }

}
