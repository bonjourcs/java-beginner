package com.bonjourcs.java.jc.interfaces.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description: Set interface test
 * Date: 2018/6/4
 */
public class SetInterfaceTest {

    @Test
    public void testRemoveDuplication() {

        List<String> list = Arrays.asList("Hello", "Hello", "World");
        Assert.assertEquals(2, SetInterface.removeDuplication(list).size());

    }

    @Test
    public void testSafeDelete() {

        // UnsupportedOperationException happens
//        List<String> list = Arrays.asList("Hello", "World");
//        Assert.assertTrue(SetInterface.safeDelete(list, "Hello"));

        List<String> list = new ArrayList<>(3);
        list.add("Hello");
        list.add("World");

        Assert.assertTrue(SetInterface.safeDelete(list, "Hello"));

    }
}