package com.bonjourcs.java.reflection.clazz;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/10/31
 */
public class ClassUtilsTest {

    @Test
    public void testGetClassByObject() {

        Class c = ClassUtils.getClass("hello");
        Assert.assertEquals("java.lang.String", c.getName());

        Class enumClass = ClassUtils.getClass(BasicEnum.ONE);
        System.out.println(enumClass.getName());

    }

    private enum BasicEnum {
        ONE, TWO
    }

}