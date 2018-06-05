package com.bonjourcs.java.jc.interfaces.set;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Liang Chenghao
 * Description: List operation
 * Date: 2018/6/5
 */
public class ListInterface {

    public static <E> int iterator(List<E> list) {
        int count = 0;
        ListIterator<E> iterator = list.listIterator();
        while (iterator.hasNext()) {
            count++;
        }
        return count;
    }

}
