package com.bonjourcs.java.java8.reduce;

import com.bonjourcs.java.java8.entity.Fish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/1/7
 */
public class ReduceUtilsTest {

    private List<Integer> integers;

    private List<Fish> fishes;

    @Before
    public void init() {

        // initialize numbers
        integers = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 2, 1);

        // initialize fishes
        Fish fish1 = new Fish("fish1", 10);
        Fish fish2 = new Fish("fish2", 50);
        Fish fish3 = new Fish("fish3", 100);
        Fish fish4 = new Fish("fish4", 70);
        Fish fish5 = new Fish("fish5", 50);
        fishes = Arrays.asList(fish1, fish2, fish3, fish4, fish5);

    }

    @Test
    public void testCollectorFunction() {

        // filter and count
        int size = fishes.stream().filter(fish -> fish.getCalories() > 50)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        Assert.assertEquals(2, size);

        size = (int) fishes.stream().filter(fish -> fish.getCalories() > 50)
                .count();
        Assert.assertEquals(2, size);

    }

    @Test
    public void testJoining() {

        String expect = "fish1,fish2,fish3,fish4,fish5";
        String result = fishes.stream().map(Fish::getName)
                .collect(Collectors.joining(","));

        Assert.assertEquals(expect, result);

        result = fishes.stream().map(Fish::getName).reduce((x, y) -> x + "," + y).get();
        Assert.assertEquals(expect, result);

    }

    @Test
    public void testSummarize() {

        // summarize
        IntSummaryStatistics statistics =
                fishes.stream().collect(Collectors.summarizingInt(Fish::getCalories));

        Assert.assertEquals(5, statistics.getCount());
        Assert.assertEquals(280, statistics.getSum());
        Assert.assertEquals(10, statistics.getMin());
        Assert.assertEquals(100, statistics.getMax());
        Assert.assertEquals(56.0, statistics.getAverage(), 0.0);

    }

    @Test
    public void testSumCalories() {

        int sum = fishes.stream().mapToInt(Fish::getCalories).sum();
        Assert.assertEquals(280, sum);

        fishes.stream().collect(Collectors.averagingInt(Fish::getCalories));
    }

    @Test
    public void findMax() {
        assertEquals(5, (int) ReduceUtils.findMax(integers.stream()).get());
    }

    @Test
    public void findMaxCalories() {

        Optional<Fish> fish = fishes.stream().max(Comparator.comparing(Fish::getCalories));
        assertEquals(100, fish.get().getCalories());

        // calculate total calories
        Assert.assertEquals(280, fishes.stream().mapToInt(Fish::getCalories).sum());

    }

    @Test
    public void testGeneratePythagoreanTriples() {
        getPythagoreanTriple().limit(5)
                .forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }

    private Stream<int[]> getPythagoreanTriple() {
        return IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
    }

    @Test
    public void testCountWord() {

        long word = 0;
        try (Stream<String> lines = Files.lines(Paths.get(getPath() + "j8f/words.txt"),
                Charset.defaultCharset())) {
            word = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct()
                    .count();
        } catch (IOException e) {
        }

        Assert.assertEquals(13, word);

    }

    private String getPath() {
        return this.getClass().getResource("/").getPath()
                .replaceFirst("/", "");
    }

    @Test
    public void testGetFibonacci() {

        List<Integer> list = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .collect(Collectors.toList());

        assertEquals(4181, (int) list.get(19));

    }

    @Test
    public void testNewGetFibonacci() {


        IntSupplier intSupplier = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int old = previous;
                int next = previous + current;
                previous = current;
                current = next;
                return old;
            }
        };

        int[] array = IntStream.generate(intSupplier).limit(20)
                .toArray();

        Assert.assertEquals(4181, array[19]);

    }

    @Test
    public void testMapPartition() {

        // use map as partition method
        Map<Boolean, List<Fish>> partition =
                fishes.stream()
                        .collect(Collectors.groupingBy(fish -> fish.getCalories() >= 50));
        Assert.assertEquals(4, partition.get(true).size());

    }

    @Test
    public void testPartition() {

        Map<Boolean, List<Fish>> partition = fishes.stream().collect(Collectors.partitioningBy(fish -> fish.getCalories() >= 50));
        Assert.assertEquals(4, partition.get(true).size());

    }

    @Test
    public void testOptionalSum() {

        List<Integer> array = new ArrayList<>();
        Optional<Integer> sum = array.stream().reduce(Integer::sum);
        Assert.assertFalse(sum.isPresent());

        array.add(1);
        array.add(2);
        int intSum = array.stream().reduce(0, Integer::sum);
        Assert.assertEquals(3, intSum);


        List<Cat> cats = Arrays.asList(
                new Cat(1, "fish1"),
                new Cat(2, "fish2"),
                new Cat(3, "fish3")
        );
        int totalWeight = cats.stream().mapToInt(Cat::getWeight)
                .sum();
        Assert.assertEquals(6, totalWeight);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Cat {
        private int weight;
        private String name;
    }

}

