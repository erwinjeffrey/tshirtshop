package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Category;
import com.turing.tshirtshop.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void testQuantityOfCategory(){

        List<Category> categoryList = categoryRepository.findAll();
        Assert.assertEquals(categoryList.size(), 7);
    }

    @Test
    public void testSingleCategory(){
        Category category = categoryRepository.findById(2);
        Assert.assertEquals("Italian", category.getName());
    }
}
