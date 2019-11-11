package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import com.turing.tshirtshop.entities.Review;
import com.turing.tshirtshop.models.ProductDto;
import com.turing.tshirtshop.models.ProductReviewDto;
import com.turing.tshirtshop.models.SearchProductDto;
import com.turing.tshirtshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "")
    public ResponseEntity<ProductDto> findAllProduct(@RequestParam Map<String, String> parameters) {

        int page = parameters.get("page") != null ? Integer.parseInt(parameters.get("page")) : 1;
        int limit = parameters.get("limit") != null ? Integer.parseInt(parameters.get("limit")) : 20;
        int descriptionLenght = parameters.get("description_length") != null ? Integer.parseInt(parameters.get("description_length")) : 200;

        return ResponseEntity.ok(productService.findAllProduct(page, limit, descriptionLenght));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<SearchProductDto> searchProducts(@RequestParam Map<String, String> parameters) {
        int page = parameters.get("page") != null ? Integer.parseInt(parameters.get("page")) : 1;
        int limit = parameters.get("limit") != null ? Integer.parseInt(parameters.get("limit")) : 20;
        int descriptionLenght = parameters.get("description_length") != null ? Integer.parseInt(parameters.get("description_length")) : 200;

        String seachItem = parameters.get("query_string");
        String allWordsStatus = parameters.get("all_words");

        return ResponseEntity.ok(productService.searchProducts(seachItem, allWordsStatus, descriptionLenght, limit, page));
    }

    @GetMapping(path = "/{product_id}")
    public ResponseEntity<ProductInfoCustom> searchProduct(@PathVariable("product_id") int productId, @RequestParam Map<String, String> parameters) {
        int descriptionLenght = parameters.get("description_length") != null ? Integer.parseInt(parameters.get("description_length")) : 200;
        return ResponseEntity.ok(productService.searchProduct(productId, descriptionLenght));
    }

    @GetMapping(path = "/inCategory/{category_id}")
    public ResponseEntity<SearchProductDto> searchProductsByCategory(@PathVariable("category_id") int categoryId, @RequestParam Map<String, String> parameters) {
        int page = parameters.get("page") != null ? Integer.parseInt(parameters.get("page")) : 1;
        int limit = parameters.get("limit") != null ? Integer.parseInt(parameters.get("limit")) : 20;
        int descriptionLenght = parameters.get("description_length") != null ? Integer.parseInt(parameters.get("description_length")) : 200;

        return ResponseEntity.ok(productService.searchProductsByCategory(categoryId, descriptionLenght, limit, page));
    }

    @GetMapping(path = "/inDepartment/{department_id}")
    public ResponseEntity<SearchProductDto> searchProductsByDepartment(@PathVariable("department_id") int departmentId, @RequestParam Map<String, String> parameters) {
        int page = parameters.get("page") != null ? Integer.parseInt(parameters.get("page")) : 1;
        int limit = parameters.get("limit") != null ? Integer.parseInt(parameters.get("limit")) : 20;
        int descriptionLenght = parameters.get("description_length") != null ? Integer.parseInt(parameters.get("description_length")) : 200;

        return ResponseEntity.ok(productService.searchProductsByDepartment(departmentId, descriptionLenght, limit, page));
    }

    /*
    This endpoint returns a list reviews for a product using the product id in the request params.
     */
    @GetMapping(path = "/{product_id}/reviews")
    public ResponseEntity<ProductReviewDto> searchProductsByDepartment(@PathVariable("product_id") int productId) {
        return ResponseEntity.ok(productService.searchReviewByProduct(productId));
    }

    @PostMapping(path = "/{product_id}/reviews")
    public ResponseEntity<Review> saveReview(@PathVariable("product_id") int productId, @Valid @RequestBody Review review) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri())
                .body(productService.save(productId, review));
    }


}
