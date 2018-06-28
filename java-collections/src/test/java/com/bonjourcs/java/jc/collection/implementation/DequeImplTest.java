package com.bonjourcs.java.jc.collection.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/28
 */
public class DequeImplTest {

    Deque<String> deque;

    @Before
    public void init() {
        deque = new ArrayDeque<>(10);
    }

    @Test
    public void testInsert() {

        DequeImpl.insert(deque, "Hello");
        Assert.assertEquals(1, deque.size());
        deque.removeFirst();
        Assert.assertEquals(0, deque.size());

    }

    @Test
    public void testTraversal() {

        deque.add("Hello");
        deque.add("World");
        deque.add("!");

        for (String aDeque : deque) {
            if ("World".equals(aDeque)) {
                deque.remove();
            }
        }
        deque.forEach(System.out::print);

    }

}