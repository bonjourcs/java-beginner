package com.bonjourcs.java.java8.parallel;

import org.junit.After;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/3/15
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
@State(Scope.Benchmark)
public class ParallelUtilsTest {

    private static final ParallelUtils parallelUtils = new ParallelUtils();
    private static long COUNT = 1_000_000;

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

    @Test
    @Benchmark
    public void testSequentialSum() {
        parallelUtils.sum(COUNT);
    }


    @After
    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }

}
