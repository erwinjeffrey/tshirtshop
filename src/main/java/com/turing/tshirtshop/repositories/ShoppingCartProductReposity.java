package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartProductReposity extends JpaRepository<ShoppingCartProduct, Integer> {

    @Query(nativeQuery = true, value = "call shopping_cart_get_products(:inCartId)")
    public List<ShoppingCartProduct> findShoppingCartProduct(@Param("inCartId") String inCartId);
}
