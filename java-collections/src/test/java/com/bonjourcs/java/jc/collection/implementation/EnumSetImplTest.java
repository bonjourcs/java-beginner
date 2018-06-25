package com.bonjourcs.java.jc.collection.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/25
 */
public class EnumSetImplTest {

    private EnumSet<ColorEnum> enums;

    @Before
    public void init() {
        enums = EnumSet.of(ColorEnum.BLUE, ColorEnum.RED, ColorEnum.PINK);
    }

    @Test
    public void testGetEnumSet() {
        Assert.assertEquals(3, EnumSetImpl.getEnumSetSize(enums));
    }

}