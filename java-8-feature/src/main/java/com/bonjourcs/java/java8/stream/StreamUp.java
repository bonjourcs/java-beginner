package com.bonjourcs.java.java8.stream;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: Stream up and running
 * Date: 2018/12/24
 */
public class StreamUp {

    public static <T> void consumeStream(Stream<T> stream, Consumer<T> consumer) {
        stream.forEach(consumer);
    }

}
