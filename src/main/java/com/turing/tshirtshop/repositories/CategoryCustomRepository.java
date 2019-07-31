package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.CategoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryCustomRepository extends JpaRepository<CategoryCustom, Integer> {

    @Query(nativeQuery = true, value = "call catalog_get_categories_for_product(:inProductId)")
    CategoryCustom findCategoryByProduct(@Param("inProductId") int productId);

}
