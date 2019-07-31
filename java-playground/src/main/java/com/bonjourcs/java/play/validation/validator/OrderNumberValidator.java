package com.bonjourcs.java.play.validation.validator;

import com.bonjourcs.java.play.validation.annotation.OrderNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/7/31
 */
public class OrderNumberValidator implements ConstraintValidator<OrderNumber, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

}
