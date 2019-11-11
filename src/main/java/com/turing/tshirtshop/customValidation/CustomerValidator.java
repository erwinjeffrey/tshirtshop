package com.turing.tshirtshop.customValidation;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.repositories.CustomerRepository;
import com.turing.tshirtshop.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<ValidCustomer, Integer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return customerRepository.findById(value).orElse(null) != null;
    }
}
