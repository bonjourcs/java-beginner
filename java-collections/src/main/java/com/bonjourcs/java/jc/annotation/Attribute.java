package com.bonjourcs.java.jc.annotation;

import java.lang.annotation.*;

/**
 * @author Liang Chenghao
 * Description: attribute annotation
 * Date: 2018/6/7
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {

    /**
     * if the attribute is required
     * default false
     *
     * @return required status
     */
    boolean required() default false;

}
