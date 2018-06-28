package com.bonjourcs.java.jc.collection.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/26
 */
public class ListImplTest {

    private List<String> list;

    @Before
    public void init() {
        list = Arrays.asList("1", "2", "3", "4");
    }

    @Test
    public void testList() {
        Assert.assertEquals(1, ListImpl.list(list, "2"));
    }

}