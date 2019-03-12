package com.bonjourcs.java.java8.collect;

import com.bonjourcs.java.java8.stream.StreamUp;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/3/12
 */
public class PrimeNumberCollector implements Collector<Integer, Map<Boolean, List<Integer>>,
        Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {

        return () -> new HashMap<Boolean, List<Integer>>(2) {
            {
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }
        };

    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {

        return (Map<Boolean, List<Integer>> acc, Integer candidate) ->
                acc.get(isPrime(acc.get(true), candidate))
                        .add(candidate);

    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {

        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };

    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    /**
     * prime predicate
     *
     * @param primes    prime divisor
     * @param candidate number to judge
     * @return given number is prime number
     */
    private boolean isPrime(List<Integer> primes, int candidate) {

        int candidateRoot = (int) Math.sqrt(candidate);

        return StreamUp.takeWhile(primes, p -> p <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);

        // only available in java 9 and above
//       return primes.stream()
//                .takeWhile(p -> p <= candidateRoot)
//                .noneMatch(p -> candidate % p == 0);
    }
}
