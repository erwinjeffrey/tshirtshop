package com.turing.tshirtshop.customValidation;

import com.turing.tshirtshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<ValidCategory, Integer> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return categoryService.findCategoryById(value) != null;
    }
}
