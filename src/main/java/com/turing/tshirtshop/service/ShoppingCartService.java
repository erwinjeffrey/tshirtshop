package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.models.UniqueId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface ShoppingCartService{
    ShoppingCart addProductToShoppingCart(Map<String, String> headers, ShoppingCart shoppingCart);
    UniqueId generateUniqueId();
}
