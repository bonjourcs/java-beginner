package com.bonjourcs.java.reflection.clazz;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
        Assert.assertEquals("com.bonjourcs.java.reflection.clazz.ClassUtilsTest$BasicEnum",
                enumClass.getName());

        // this returns  Class which corresponds to an array with component type byte
        String[] strings = new String[24];
        Class arrayClass = ClassUtils.getClass(strings);

        Set<String> set = new HashSet<>(3);
        Assert.assertEquals("java.util.HashSet", ClassUtils.getClass(set).getName());

        // get Class from a primitive type object
        Assert.assertEquals("java.lang.Boolean", ClassUtils.getClass(false).getName());

    }

    private enum BasicEnum {
        ONE, TWO
    }

}