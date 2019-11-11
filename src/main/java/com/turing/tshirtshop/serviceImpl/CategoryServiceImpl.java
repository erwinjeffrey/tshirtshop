package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.entities.Category;
import com.turing.tshirtshop.custom.CategoryCustom;
import com.turing.tshirtshop.models.CategoryDepartmentWrapper;
import com.turing.tshirtshop.models.CategoryWrapper;
import com.turing.tshirtshop.repositories.CategoryCustomRepository;
import com.turing.tshirtshop.repositories.CategoryDepartCusRepository;
import com.turing.tshirtshop.repositories.CategoryRepository;
import com.turing.tshirtshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryCustomRepository categoryCustomRepository;
    @Autowired
    private CategoryDepartCusRepository categoryDepartCusRepository;

    @Override
    @Cacheable("categories")
    public CategoryWrapper findAllCategories() {
        CategoryWrapper categoryWrapper = new CategoryWrapper();
        categoryWrapper.setRows(categoryRepository.findAll());
        return categoryWrapper;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public CategoryCustom findCategoryByProduct(int productId) {
       return categoryCustomRepository.findCategoryByProduct(productId);
    }

    @Override
    public CategoryDepartmentWrapper findCategoriesByDepartment(int departmentId) {
        CategoryDepartmentWrapper categoryWrapper = new CategoryDepartmentWrapper();
        categoryWrapper.setRows(categoryDepartCusRepository.findCategoriesByDepartment(departmentId));
        return categoryWrapper;
    }
}
