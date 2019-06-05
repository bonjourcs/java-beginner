package com.bonjourcs.java.java8.parallel;

import org.junit.Test;

import java.util.concurrent.ForkJoinTask;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/5
 */
public class ForkJoinSumCalculatorTest {

    /**
     * in this test, computeSequentially is more effective than forkJoinSumCalculator
     */
    @Test
    public void testForkJoinSumCalculator() {

        int len = 1_000_000;
        int[] numbers = IntStream.rangeClosed(1, len).toArray();

        logTime((long) len, this::calculateSum);

        logTime(numbers, this::computeSequentially);

    }


    private long calculateSum(long n) {

        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinSumCalculator(numbers);

        return forkJoinTask.invoke();

    }

    private long computeSequentially(int[] numbers) {

        long sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;

    }

    private <T> void logTime(T t, Consumer<T> consumer) {

        long timeStart = System.currentTimeMillis();
        consumer.accept(t);
        long timeEnd = System.currentTimeMillis();

        System.out.println("Time spend: " + (timeEnd - timeStart) + " ms");

    }
}
