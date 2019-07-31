package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.Category;
import com.turing.tshirtshop.custom.CategoryCustom;
import com.turing.tshirtshop.entities.models.CategoryDepartmentWrapper;
import com.turing.tshirtshop.entities.models.CategoryWrapper;

public interface CategoryService {
    CategoryWrapper findAllCategories();
    Category findCategoryById(int categoryId);
    CategoryCustom findCategoryByProduct(int productId);
    CategoryDepartmentWrapper findCategoriesByDepartment(int departmentId);
}
