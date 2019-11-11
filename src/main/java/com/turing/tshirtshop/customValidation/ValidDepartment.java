package com.turing.tshirtshop.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DepartmentValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD})
public @interface ValidDepartment {
    public String message() default "Don'exist department with this ID";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
