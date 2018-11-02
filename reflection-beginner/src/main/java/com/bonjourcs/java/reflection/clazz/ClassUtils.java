package com.bonjourcs.java.reflection.clazz;

/**
 * @author Liang Chenghao
 * Description: reflection class utils
 * Date: 2018/10/31
 */
public class ClassUtils {

    /**
     * get class by object
     *
     * @param o object to get class
     * @return object class
     */
    public static Class getClass(Object o) {
        return o.getClass();
    }

    /**
     * get class by name
     *
     * @param className class name
     * @return class
     * @throws ClassNotFoundException when class not found, this happens
     */
    public static Class getClassFromName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

}
