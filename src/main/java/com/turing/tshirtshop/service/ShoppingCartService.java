package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartService{
    ShoppingCart addProductToShoppingCart(ShoppingCart shoppingCart);
}
