package com.bonjourcs.java.play.validation.annotation;

import com.bonjourcs.java.play.validation.validator.OrderNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/7/31
 */
@Documented
@Constraint(validatedBy = OrderNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface OrderNumber {

    String message() default "{com.bonjourcs.java.play.validation.annotation.OrderNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

