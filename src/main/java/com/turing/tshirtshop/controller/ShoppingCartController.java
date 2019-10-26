package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.models.UniqueId;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> addProductToShoppingCart(@RequestHeader Map<String, String> headers, @RequestBody ShoppingCart shoppingCart){
       return ResponseEntity.ok(shoppingCartService.addProductToShoppingCart(headers,shoppingCart));
    }

    @GetMapping("/generateUniqueId")
    public ResponseEntity<UniqueId> generateUniqueId(){
        return ResponseEntity.ok(shoppingCartService.generateUniqueId());
    }
}
