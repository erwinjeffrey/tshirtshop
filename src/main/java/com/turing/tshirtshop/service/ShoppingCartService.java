package com.turing.tshirtshop.service;

import com.turing.tshirtshop.custom.ShoppingCartProduct;
import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.models.ShoppingMessage;
import com.turing.tshirtshop.models.UniqueId;

import java.util.List;

public interface ShoppingCartService{
    List<ShoppingCart> addProductToShoppingCart(ShoppingCart shoppingCart);
    UniqueId generateUniqueId();

    List<ShoppingCartProduct>findShoppingCartProduct(String cartId);

    ShoppingCart updateShoppingCart(String itemId,int quantity);

    List<ShoppingCart> emptyShoppingCart(String cartId);

    ShoppingMessage removeShoppingCartProd(String itemId);
}
