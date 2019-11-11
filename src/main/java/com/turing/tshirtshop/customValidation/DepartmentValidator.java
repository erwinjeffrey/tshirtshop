package com.turing.tshirtshop.customValidation;

import com.turing.tshirtshop.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentValidator implements ConstraintValidator<ValidDepartment, Integer> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return departmentRepository.findById(value) != null;
    }
}
