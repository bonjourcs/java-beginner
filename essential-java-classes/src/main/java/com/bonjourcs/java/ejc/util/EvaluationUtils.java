package com.bonjourcs.java.ejc.util;

import java.util.function.Consumer;

/**
 * @author Liang Chenghao
 * Description: evaluateion utils
 * Date: 2019/6/6
 */
public class EvaluationUtils {

    /**
     * calculate method execute time
     *
     * @param t        method parameter
     * @param consumer consumer
     * @param <T>      generic type
     * @return time interval
     */
    public static <T> long evaluateTime(T t, Consumer<T> consumer) {

        long timeStart = System.currentTimeMillis();
        consumer.accept(t);
        long timeEnd = System.currentTimeMillis();

        return timeEnd - timeStart;

    }
}
