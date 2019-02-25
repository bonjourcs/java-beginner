package com.bonjourcs.java.java8.stream;

import com.sun.javafx.image.IntPixelGetter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    public void testFlatMap() {

        Assert.assertEquals(13, strings.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .size());

    }

    @Test
    public void testMap() {

        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(4, 5);

        Assert.assertEquals(6, integers1.stream()
                .flatMap(i -> integers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList()).size());

    }

    @Test
    public void testFlatMapping() {

        Assert.assertEquals(2, Stream.of(Arrays.asList("a"), Arrays.asList("b"))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()).size());

    }

    @Test
    public void testGeneratePrime() {

        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, 100000)
                .boxed()
                .collect(Collectors.partitioningBy(this::isPrime));

        Assert.assertEquals(9592, map.get(true).size());

    }

    /**
     * prime predicate
     *
     * @param num number to judge
     * @return given number is prime number
     */
    private boolean isPrime(int num) {

        int medium = (int) Math.sqrt(num);
        return IntStream.rangeClosed(2, medium)
                .noneMatch(i -> num % i == 0);

    }

}