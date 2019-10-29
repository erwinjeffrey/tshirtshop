package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.custom.ShoppingCartProduct;
import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.models.ShoppingMessage;
import com.turing.tshirtshop.models.UniqueId;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public ResponseEntity<List<ShoppingCart>> addProductToShoppingCart(@RequestBody ShoppingCart shoppingCart){
       return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri()).body(shoppingCartService.addProductToShoppingCart(shoppingCart));
    }

    @GetMapping("/generateUniqueId")
    public ResponseEntity<UniqueId> generateUniqueId(){
        return ResponseEntity.ok(shoppingCartService.generateUniqueId());
    }

    @GetMapping("/{cart_id}")
    public ResponseEntity<List<ShoppingCartProduct>> findShoppingCartProduct(@PathVariable("cart_id") String cartId){
        return ResponseEntity.ok(shoppingCartService.findShoppingCartProduct(cartId));
    }

    @PutMapping("/update/{item_id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable("item_id") String itemId, @RequestBody ShoppingCart shoppingCart){
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(itemId,shoppingCart.getQuantity()));
    }

    @DeleteMapping("/empty/{cart_id}")
    public ResponseEntity<List<ShoppingCart>> emptyShoppingCart(@PathVariable("cart_id") String cartId){
        return ResponseEntity.ok(shoppingCartService.emptyShoppingCart(cartId));
    }

    @DeleteMapping("/removeProduct/{item_id}")
    public ResponseEntity<ShoppingMessage> removeShoppingCartProd(@PathVariable("item_id") String itemId){
        return ResponseEntity.ok(shoppingCartService.removeShoppingCartProd(itemId));
    }
}
