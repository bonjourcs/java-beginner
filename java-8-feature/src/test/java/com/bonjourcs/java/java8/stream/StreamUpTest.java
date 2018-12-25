package com.bonjourcs.java.java8.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/12/24
 */
public class StreamUpTest {

    private List<String> strings;

    private List<Integer> integers;

    @Before
    public void init() {
        strings = Arrays.asList("Hello", "World", "I", "Am", "A", "Programmer");
        integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test(expected = IllegalStateException.class)
    public void consumeStream() {

        Stream<String> stream = strings.stream();

        // stream can only action once
        StreamUp.consumeStream(stream, System.out::println);
        StreamUp.consumeStream(stream, System.out::println);

    }

    @Test
    public void testFilterUnique() {

        strings = Arrays.asList("Hello", "Hello", "World", "Am");
        Assert.assertEquals(2,
                StreamUp.filterUnique(strings, s -> s != null && s.length() > 3).size());

    }

    @Test
    public void testSliceStream() {

        // this is supported on java 9 and above
//        Assert.assertEquals(5, integers.stream()
//                .takeWhile(i -> i <= 5).collect(Collectors.toList()).size());
//        Assert.assertEquals(5, integers.stream()
//                .dropWhile(i -> i <= 5).collect(Collectors.toList()).size());

    }

    @Test
    public void testFlatMap(){

        Assert.assertEquals(13,strings.stream()
                .map(s->s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .size());

    }

}