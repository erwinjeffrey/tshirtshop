package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductInfoCustomRepository extends JpaRepository<ProductInfoCustom, Integer> {

    @Query(nativeQuery = true, value = "call catalog_get_product_info(:inProductId)")
    ProductInfoCustom searchProduct(@Param("inProductId") int productId);
}
