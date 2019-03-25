package com.bonjourcs.java.java8.parallel;

import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/3/15
 */
public class ParallelUtils {

    /**
     * sum with stream operation
     *
     * @param n n numbers
     * @return sum of the n numbers
     */
    public long sum(long n) {

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);

    }

    /**
     * parallel sum with stream operation
     *
     * @param n n numbers
     * @return sum of the n numbers
     */
    public long parallelSum(long n) {

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);

    }

}
