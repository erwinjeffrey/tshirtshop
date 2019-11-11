package com.turing.tshirtshop.customValidation;

import com.turing.tshirtshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !customerService.isEmailAlreadyInUse(value);
    }
}
