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

    @Test
    public void testGetClassByName() throws ClassNotFoundException, NoSuchFieldException {

        // primitive type class
        String name = "java.lang.String";
        Class clazz = ClassUtils.getClassFromName(name);

        // double array class
        name = "[D";
        clazz = ClassUtils.getClassFromName(name);

        // fixed class from wrapped class
        clazz = Double.TYPE;
        clazz = Void.TYPE;

        // get all public member classes of Character
        Class<?>[] classes = Character.class.getClasses();
        Assert.assertEquals(3, classes.length);

        // get all member classes of Character
        classes = Character.class.getDeclaredClasses();
        Assert.assertEquals(4, classes.length);

        // out is declared in class System
        Class<?> someClass = System.class.getField("out").getDeclaringClass();

        Object o = new Object() {
            void init() {

            }
        };

        // the declaring class of the anonymous class defined by o is null
        Assert.assertNull(o.getClass().getDeclaringClass());

    }

    private enum BasicEnum {
        ONE, TWO
    }

}