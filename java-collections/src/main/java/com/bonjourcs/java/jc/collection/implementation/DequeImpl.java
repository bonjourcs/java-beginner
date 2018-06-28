package com.bonjourcs.java.jc.collection.implementation;

import java.util.Deque;

/**
 * @author Liang Chenghao
 * Description: Deque implementations
 * Date: 2018/6/28
 */
public class DequeImpl {

    /**
     * add element to a deque in the first place
     *
     * @param deque   a deque
     * @param element element to insert
     * @param <E>     generic type
     */
    public static <E> void insert(Deque<E> deque, E element) {
        deque.addFirst(element);
    }

}
