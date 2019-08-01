package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> addProductToShoppingCart(@RequestBody ShoppingCart shoppingCart){
       return ResponseEntity.ok(service.addProductToShoppingCart(shoppingCart));
    }
}
