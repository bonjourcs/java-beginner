package com.bonjourcs.java.java8.reduce;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: test class for reducing
 * Date: 2019/1/7
 */
public class ReduceUtils {

    public static Optional<Integer> findMax(Stream<Integer> stream) {
        return stream.reduce(Integer::max);
    }

}
