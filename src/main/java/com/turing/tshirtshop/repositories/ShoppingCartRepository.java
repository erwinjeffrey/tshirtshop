package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {

    @Query(nativeQuery = true, value = "call shopping_cart_add_product(:inCartId,:inProductId,:inAttributes)")
    void addProductToShoppingCart(@Param("inCartId") char cartId,@Param("inProductId")int productId,
                                          @Param("inAttributes")String attribute);
}
