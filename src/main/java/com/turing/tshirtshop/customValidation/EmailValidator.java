package com.turing.tshirtshop.customValidation;

import com.turing.tshirtshop.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Autowired
    private EmailService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && service.emailValidator(value);
    }
}
