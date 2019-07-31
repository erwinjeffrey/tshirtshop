package com.turing.tshirtshop.service;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import com.turing.tshirtshop.entities.Product;
import com.turing.tshirtshop.entities.models.ProductDto;
import com.turing.tshirtshop.entities.models.SearchProductDto;

import java.util.List;

public interface ProductService {
    ProductDto  findAllProduct(int page, int limit, int descriptionLenght);

    SearchProductDto searchProducts(String searchItem,String allWorldStatus,int descriptionLenght, int limit,int page);

    ProductInfoCustom searchProduct(int productId, int descriptionLenght);

    List<Product> searchProductsByCategory(int categoryId, int descriptionLength,
                                           int limit, int page);
}