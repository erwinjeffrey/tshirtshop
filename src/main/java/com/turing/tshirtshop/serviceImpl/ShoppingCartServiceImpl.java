package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.repositories.ShoppingCartRepository;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    @Override
    public ShoppingCart addProductToShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.addProductToShoppingCart(shoppingCart.getCart_id(),shoppingCart.getProduct_id(),shoppingCart.getAttributes());
        return null;
    }
}
