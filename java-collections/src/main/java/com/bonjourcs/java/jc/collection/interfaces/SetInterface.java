package com.bonjourcs.java.jc.collection.interfaces;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Liang Chenghao
 * Description: operations on Set
 * Date: 2018/6/4
 */
public class SetInterface {


    /**
     * remove duplicate element from a collection
     *
     * @param c   collection to remove duplicate element
     * @param <E> collection type
     * @return target collection
     */
    public static <E> Set removeDuplication(Collection<E> c) {
        return new HashSet<>(c);
    }

    /**
     * safe remove element from collection
     *
     * @param c   source collection
     * @param e   element to remove
     * @param <E> collection type
     */
    public static <E> boolean safeDelete(Collection<E> c, E e) {
        return c.removeIf(x -> x.equals(e));
    }

}
