package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import com.turing.tshirtshop.entities.Product;
import com.turing.tshirtshop.entities.models.ProductDto;
import com.turing.tshirtshop.entities.models.SearchProductDto;
import com.turing.tshirtshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "")
    public ResponseEntity<ProductDto> findAllProduct(@RequestParam Map<String,String> parameters){

        int page = parameters.get("page") != null ? Integer.parseInt(parameters.get("page")) : 1;
        int limit = parameters.get("limit") != null ? Integer.parseInt(parameters.get("limit")) : 20;
        int descriptionLenght = parameters.get("description_length")  != null ? Integer.parseInt(parameters.get("description_length")) : 200;

        return ResponseEntity.ok( productService.findAllProduct(page,limit,descriptionLenght));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<SearchProductDto> searchProducts(@RequestParam Map<String,String> parameters){
        int page = parameters.get("page") != null ? Integer.parseInt(parameters.get("page")) : 1;
        int limit = parameters.get("limit") != null ? Integer.parseInt(parameters.get("limit")) : 20;
        int descriptionLenght = parameters.get("description_length")  != null ? Integer.parseInt(parameters.get("description_length")) : 200;
        String seachItem = parameters.get("query_string");
        String allWordsStatus = parameters.get("all_words");

        return ResponseEntity.ok(productService.searchProducts(seachItem,allWordsStatus,descriptionLenght,limit,page));
    }

    @GetMapping(path = "/{product_id}")
    public ResponseEntity<ProductInfoCustom> searchProduct(@PathVariable("product_id") int productId, @RequestParam Map<String,String> parameters){
        int descriptionLenght = parameters.get("description_length")  != null ? Integer.parseInt(parameters.get("description_length")) : 200;
        return ResponseEntity.ok(productService.searchProduct(productId,descriptionLenght));
    }

}
