package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    List<Category> findAll();
    Category findById(int categoryId);

}
