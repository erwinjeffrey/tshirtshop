package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import com.turing.tshirtshop.entities.Product;
import com.turing.tshirtshop.entities.models.PaginationMetaDto;
import com.turing.tshirtshop.entities.models.ProductDto;
import com.turing.tshirtshop.entities.models.SearchProductDto;
import com.turing.tshirtshop.repositories.ProductInfoCustomRepository;
import com.turing.tshirtshop.repositories.ProductRepository;
import com.turing.tshirtshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInfoCustomRepository productInfoCustomRepository;

    @Override
    public ProductDto findAllProduct(int page, int limit,int descriptionLenght) {
         Pageable pageable = PageRequest.of(page,limit);

        ProductDto productDto = new ProductDto();
        List<Product> products = productRepository.findAll(pageable).getContent();


        StringBuilder description = new StringBuilder();


         for(Product  product: products){

             String resultDescription = null;
             description.append(product.getDescription());
             if(description.length() > descriptionLenght){
                 resultDescription = description.substring(0,descriptionLenght+1);
                 resultDescription = resultDescription + "...";
             }else{
                 resultDescription = product.getDescription();
             }
             product.setDescription(resultDescription);

             description.delete(0,description.length());
         }
         //TODO MUST BE COMPLETED
        productDto.setPaginationMeta(new PaginationMetaDto(page,limit,0,0));
        productDto.setRows(products);
       return productDto;
    }

    @Override
    public SearchProductDto searchProducts(String searchItem, String allWorldStatus, int descriptionLenght, int limit, int page) {
        SearchProductDto searchProductDto = new SearchProductDto();
        searchProductDto.setRows(productRepository.searchProducts(searchItem,allWorldStatus,descriptionLenght,limit,page));
        return searchProductDto;
    }

    @Override
    public ProductInfoCustom searchProduct(int productId,int descriptionLenght) {
        ProductInfoCustom productInfoCustom = productInfoCustomRepository.searchProduct(productId);
        if(productInfoCustom.getDescription().length() > descriptionLenght){
            productInfoCustom.setDescription(productInfoCustom.getDescription().substring(0,descriptionLenght+1) + "...");
        }
        return productInfoCustom;
    }
}
