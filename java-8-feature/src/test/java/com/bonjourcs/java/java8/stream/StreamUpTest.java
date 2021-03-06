package com.bonjourcs.java.java8.stream;

import com.alibaba.fastjson.JSONObject;
import com.bonjourcs.java.java8.collect.PrimeNumberCollector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
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
                .flatMap(Collection::stream).count());

        List<String> stringList = Stream.of(Arrays.asList("1", "2", "3"), Arrays.asList("4", "5", "6"))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<String> resultList = Arrays.asList("1", "2", "3", "4", "5", "6");
        Assert.assertEquals(resultList, stringList);

    }

    @Test
    public void testGeneratePrime() {

        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, 100000)
                .boxed()
                .collect(Collectors.partitioningBy(this::isPrime));

        Assert.assertEquals(9592, map.get(true).size());

    }

    @Test
    public void testCustomPrimeNumberCollector() {
        Assert.assertTrue(calculateDuration(false) > calculateDuration(true));
    }

    private long calculateDuration(boolean custom) {

        long start = System.currentTimeMillis();
        if (custom) {
            partitionPrimeNumberWithCustomCollector(1_000_000);
        } else {
            partitionPrimeNumber(1_000_000);
        }
        long end = System.currentTimeMillis();

        return end - start;
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

    private Map<Boolean, List<Integer>> partitionPrimeNumber(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(Collectors.partitioningBy(this::isPrime));
    }

    private Map<Boolean, List<Integer>> partitionPrimeNumberWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new PrimeNumberCollector());
    }

    @Test
    public void testGenerateFibonacci() {

        IntStream.generate(new IntSupplier() {

            private int current = 0;
            private int next = 1;

            @Override
            public int getAsInt() {
                int tmp = current;
                current = next;
                next = tmp + current;
                return tmp;
            }

        }).limit(30)
                .forEach(System.out::println);

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Fish {

        /**
         * fish color
         */
        private String color;

        /**
         * fish weight
         */
        private int weight;

    }

    @Test
    public void testMapWithMax() {

        List<Fish> fishes = Arrays.asList(
                new Fish("blue", 100),
                new Fish("blue", 80),
                new Fish("blue", 70),
                new Fish("yellow", 100),
                new Fish("yellow", 10),
                new Fish("black", 100),
                new Fish("black", 10),
                new Fish("black", 100),
                new Fish("black", 1000)
        );

        Map<String, Optional<Fish>> map = fishes.stream()
                .collect(Collectors.groupingBy(Fish::getColor,
                        Collectors.maxBy(Comparator.comparingInt(Fish::getWeight))));

        // not Optional.empty();
        Assert.assertNull(map.get("pink"));

        // this returns a Map<String,Fish> entity
        Map<String, Fish> map1 = fishes.stream()
                .collect(Collectors.groupingBy(Fish::getColor,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Fish::getWeight)),
                                Optional::get)));
        Assert.assertNull(map1.get("pink"));

    }


    @Test
    public void testStreamGenerate() {

        Supplier<Foo> fooSupplier = () -> {
            Foo foo = new Foo();
            foo.setDate(new Date(System.currentTimeMillis()));
            return foo;
        };

        Stream.generate(fooSupplier).limit(3).forEach(e ->
                System.out.println(JSONObject.toJSONString(e)));

    }

    @Data
    class Foo {
        private Date date;
    }

    @Test
    public void testJoining() {

        String str = Stream.of("Hello", "World", "Java")
                .collect(Collectors.joining(",", "[", "]"));
        String result = "[Hello,World,Java]";
        Assert.assertEquals(result, str);

    }

}
