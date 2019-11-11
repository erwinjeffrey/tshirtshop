package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.repositories.ShoppingCartRepository;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartServiceTest {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;


    private static String cardId;

    @BeforeClass
    public static void setup(){
        cardId = "94d7a7dc-6f75-4e23-9628-f555cc9c895d";
    }

    @Test
    public void addProductToCartSuccessful(){

        shoppingCartRepository.addProductToShoppingCart(cardId,2,"color");
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findByCartId(cardId);

        Assert.assertEquals(shoppingCarts.size(), 1);

        shoppingCartRepository.emptyShoppingCart(shoppingCarts.get(0).getCartId());

    }

    @Test
    public void updateShoppingCartSuccessful(){
        shoppingCartRepository.addProductToShoppingCart(cardId,2,"color");
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findByCartId(cardId);

        shoppingCartRepository.updateShoppingCart(shoppingCarts.get(0).getItemId(),3);
        List<ShoppingCart> updateShoppingCarts = shoppingCartRepository.findByCartId("94d7a7dc-6f75-4e23-9628-f555cc9c895d");

        Assert.assertEquals(updateShoppingCarts.get(0).getQuantity(), 3);
        shoppingCartRepository.emptyShoppingCart(updateShoppingCarts.get(0).getCartId());
    }

    @Test
    public void removeShoppingCartProdSuccessful(){
        shoppingCartRepository.addProductToShoppingCart(cardId,2,"color");
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findByCartId(cardId);
        Assert.assertEquals("color", shoppingCarts.get(0).getAttributes());
        shoppingCartRepository.removeShoppingCartProd(shoppingCarts.get(0).getItemId());
    }

    @Test
    public void generateUniqueId(){
        Assert.assertTrue(shoppingCartService.generateUniqueId().getCartId().length() == 36);
    }
}
