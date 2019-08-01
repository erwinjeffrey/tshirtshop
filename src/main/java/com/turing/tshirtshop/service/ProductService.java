package com.turing.tshirtshop.service;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import com.turing.tshirtshop.entities.Review;
import com.turing.tshirtshop.models.ProductDto;
import com.turing.tshirtshop.models.ProductReviewDto;
import com.turing.tshirtshop.models.SearchProductDto;

public interface ProductService {
    ProductDto  findAllProduct(int page, int limit, int descriptionLenght);

    SearchProductDto searchProducts(String searchItem,String allWorldStatus,int descriptionLenght, int limit,int page);

    ProductInfoCustom searchProduct(int productId, int descriptionLenght);

    SearchProductDto searchProductsByCategory(int categoryId, int descriptionLength,
                                           int limit, int page);

    SearchProductDto searchProductsByDepartment(int departementId, int descriptionLength,
                                              int limit, int page);

    ProductReviewDto searchReviewByProduct(int productId);

    Review save(int productId, Review review);
}