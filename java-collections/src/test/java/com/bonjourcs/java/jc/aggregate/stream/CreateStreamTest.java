package com.bonjourcs.java.jc.aggregate.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/10
 */
public class CreateStreamTest {

    @Test
    public void testShowStream() {
        CreateStream createStream = new CreateStream();
        createStream.showStream("show double stream",
                createStream.generateStream(), 10);
    }

    @Test
    public void testShowToUpperStringStream() {
        Stream<String> stringStream = Stream
                .of("Hello", "World", "I", "Love", "This", "World");
        // use map operate
        new CreateStream().showStream("upper string stream", stringStream.map(String::toUpperCase), 10);
    }

    @Test
    public void testIterateStream() {

        // reduction operation will generate a list
        Arrays.asList(Stream.iterate(1, p -> p * 2)
                .peek(e -> System.out.println("generate element : " + e))
                .limit(10)
                .toArray())
                .forEach(System.out::println);
    }
}