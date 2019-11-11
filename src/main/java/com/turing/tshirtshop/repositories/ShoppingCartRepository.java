package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.ShoppingCartProduct;
import com.turing.tshirtshop.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {

    @Procedure(name = "addProductToCart")
    void addProductToShoppingCart(@Param("inCartId") String cartId,@Param("inProductId")int productId,
                                          @Param("inAttributes")String attribute);

    List<ShoppingCart> findByCartId(String cartId);

    @Procedure(name = "updateShoppingCart")
    void updateShoppingCart(@Param("inItemId") String itemId,@Param("inQuantity") int quantity);

    ShoppingCart findByItemId(String itemId);

    @Procedure(name = "emptyShoppingCart")
    void emptyShoppingCart(@Param("inCartId") String cartId);

    @Procedure(name = "removeShoppingCartProd")
    void removeShoppingCartProd(@Param("inItemId") String itemId);

}
