package com.bonjourcs.java.play.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/1/16
 */
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Repeatable(value = CommonConstraint.List.class)
@Documented
public @interface CommonConstraint {

    boolean required() default false;

    String message() default "{com.bonjourcs.java.play.constraint.CommonConstraintMessage.ERROR_MESSAGE}";

    String name() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CommonConstraint[] value();
    }

}
