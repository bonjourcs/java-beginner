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


}