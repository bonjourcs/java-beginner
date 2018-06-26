package com.bonjourcs.java.jc.collection.implementation;

import java.util.List;

/**
 * @author Liang Chenghao
 * Description: List implementations
 * Date: 2018/6/26
 */
public class ListImpl {

    public static <T> int list(List<T> list, T target) {
        return list.indexOf(target);
    }

}
