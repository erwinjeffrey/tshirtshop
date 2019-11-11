package com.turing.tshirtshop.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CategoryValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD})
public @interface ValidCategory {
    public String message() default "Don't exist category with this ID";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
