package com.bonjourcs.java.jc.util;

import com.bonjourcs.java.jc.annotation.Attribute;

import java.lang.reflect.Field;

/**
 * @author Liang Chenghao
 * Description: util tools to validate attributes
 * Date: 2018/6/7
 */
public class AttributeUtils {

    public static <T> boolean validate(T t) throws IllegalAccessException {

        boolean valid = true;
        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Attribute attribute = field.getAnnotation(Attribute.class);
            if (attribute != null) {
                if (attribute.required() == (field.get(t) == null)) {
                    valid = false;
                    System.out.println(("Field [" + field.getName() + "] is required."));
                }
            }
        }

        return valid;

    }
}
