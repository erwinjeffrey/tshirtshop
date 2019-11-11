package com.turing.tshirtshop.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD})
public @interface ValidCustomer {
    public String message() default "Please provide a valid customer Id";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
