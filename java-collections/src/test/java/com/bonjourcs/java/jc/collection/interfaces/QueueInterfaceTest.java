package com.bonjourcs.java.jc.collection.interfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/6
 */
public class QueueInterfaceTest {

    @Test
    public void testAddElement() {
        Queue<Integer> queue = new PriorityQueue<>(2);
        queue.add(1);
        queue.add(2);
        Assert.assertEquals(3, QueueInterface.addElement(queue, 3));
    }

    @Test
    public void testOfferElement() {
        Queue<Integer> queue = new PriorityQueue<>(2);
        queue.add(1);
        queue.add(2);
        Assert.assertEquals(3, QueueInterface.offerElement(queue, 3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveElement() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        QueueInterface.removeElement(queue);
    }

    @Test
    public void testPollElement() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        Assert.assertNull(QueueInterface.pollElement(queue));
    }

    @Test(expected = NoSuchElementException.class)
    public void testElement() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        QueueInterface.element(queue);
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        QueueInterface.peek(queue);
    }

    @Test
    public void testFetchElement() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        // fetch element from queue
        Integer count = 0;
        while (!queue.isEmpty()) {
            Assert.assertEquals(count, queue.remove());
            count++;
        }

    }

    @Test
    public void testPriorityQueue() {

        Queue<String> queue = new PriorityQueue<>();
        queue.add("Hello");
        queue.add("World");
        queue.add("AString");

        Assert.assertEquals("AString", queue.poll());
    }

}
