package com.bonjourcs.java.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/12/24
 */
public class StreamUpTest {

    private List<String> strings;

    @Before
    public void init() {
        strings = Arrays.asList("Hello", "World", "I", "Am", "A", "Programmer");
    }

    @Test(expected = IllegalStateException.class)
    public void consumeStream() {

        Stream<String> stream = strings.stream();

        // stream can only action once
        StreamUp.consumeStream(stream, System.out::println);
        StreamUp.consumeStream(stream, System.out::println);

    }

}