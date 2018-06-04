package com.bonjourcs.java.jc.interfaces.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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

}