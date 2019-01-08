package com.bonjourcs.java.java8.reduce;

import com.bonjourcs.java.java8.entity.Fish;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.Fidelity;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

}
