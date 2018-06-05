package com.bonjourcs.java.jc.interfaces.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/5
 */
public class ListInterfaceTest {

    @Test
    public void testIterator() {
        List<String> list = Arrays.asList("Hello", "World", "Bonjour");
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testBasicListOperation() {
        List<String> list = Arrays.asList("Hello", "World", "Bonjourcs", "Ciao");
        // find element in list
        Assert.assertEquals(0, list.indexOf("Hello"));
        Assert.assertEquals(-1, list.indexOf(null));
        Assert.assertEquals(-1, list.indexOf("你好"));
        // replace element in list
        ListInterface.replace(list, "Hello", "你好");
        Assert.assertEquals(0, list.indexOf("你好"));
    }

}