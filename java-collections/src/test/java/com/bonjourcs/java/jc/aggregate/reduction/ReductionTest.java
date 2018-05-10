package com.bonjourcs.java.jc.aggregate.reduction;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: reduction test
 * Date: 2018/5/10
 */
public class ReductionTest {

    /**
     * test max reduction
     */
    @Test
    public void testMax() {
        Assert.assertTrue(!"".equals(Stream.of("Hello", "World", "This", "is")
                .max(String::compareToIgnoreCase)
                .orElse("")));
    }

    /**
     * test findAny reduction
     */
    @Test
    public void testFindAny() {
        Assert.assertTrue(
                Stream.of("Hi", "There", "Ok").anyMatch(s -> s.startsWith("H"))
        );
    }

    @Test(expected = RuntimeException.class)
    public void testOptional() {
        Stream.of("Hi", "world").filter(e -> e.startsWith("Q")).findAny().orElseThrow(RuntimeException::new);
    }

}