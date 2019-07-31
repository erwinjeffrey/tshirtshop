package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Category;
import com.turing.tshirtshop.custom.CategoryCustom;
import com.turing.tshirtshop.entities.models.CategoryDepartmentWrapper;
import com.turing.tshirtshop.entities.models.CategoryWrapper;
import com.turing.tshirtshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "")
    public ResponseEntity<CategoryWrapper> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @GetMapping(path = "/{category_id}")
    public ResponseEntity<Category> findById(@PathVariable("category_id") int categoryId){
       return ResponseEntity.ok(categoryService.findCategoryById(categoryId));
    }


    /*
      This endpoint returns the category of a particular product.
       */

    @GetMapping(path = "/inProduct/{product_id}")
    public ResponseEntity<CategoryCustom> findCategoryByProduct(@PathVariable("product_id") int productId){
        return ResponseEntity.ok(categoryService.findCategoryByProduct(productId));
    }

    /*
    This endpoint returns a list of categories in a department.
     */

    @GetMapping(path = "/inDepartment/{department_id}")
    public ResponseEntity<CategoryDepartmentWrapper> findCategoriesByDepartment(@PathVariable("department_id") int departmentId){
        return ResponseEntity.ok(categoryService.findCategoriesByDepartment(departmentId));
    }


}
