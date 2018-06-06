package com.bonjourcs.java.jc.collection.interfaces;

import java.util.Queue;

/**
 * @author Liang Chenghao
 * Description: Queue operations
 * Date: 2018/6/6
 */
public class QueueInterface {

    /**
     * add element into queue
     *
     * @param queue a queue
     * @param e     element to add
     * @param <E>   queue type
     * @return queue size
     */
    public static <E> int addElement(Queue<E> queue, E e) {
        queue.add(e);
        return queue.size();
    }

    /**
     * add element into queue
     *
     * @param queue a queue
     * @param e     element to add
     * @param <E>   queue type
     * @return queue size
     */
    public static <E> int offerElement(Queue<E> queue, E e) {
        queue.offer(e);
        return queue.size();
    }

    /**
     * remove element from a queue
     *
     * @param queue queue to operate
     * @param <E>   element type
     * @return queue head
     */
    public static <E> E removeElement(Queue<E> queue) {
        return queue.remove();
    }

    /**
     * remove element from a queue
     *
     * @param queue queue to operate
     * @param <E>   element type
     * @return queue head
     */
    public static <E> E pollElement(Queue<E> queue) {
        return queue.poll();
    }

    /**
     * show queue head element
     *
     * @param queue queue to operate
     * @param <E>   queue type
     * @return queue head
     */
    public static <E> E element(Queue<E> queue) {
        return queue.element();
    }

    /**
     * show queue head element
     *
     * @param queue queue to operate
     * @param <E>   queue type
     * @return queue head
     */
    public static <E> E peek(Queue<E> queue) {
        return queue.peek();
    }

}
