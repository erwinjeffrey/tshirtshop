package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.ProductInfoCustom;
import com.turing.tshirtshop.entities.Product;
import com.turing.tshirtshop.entities.Review;
import com.turing.tshirtshop.models.PaginationMetaDto;
import com.turing.tshirtshop.models.ProductDto;
import com.turing.tshirtshop.models.ProductReviewDto;
import com.turing.tshirtshop.models.SearchProductDto;
import com.turing.tshirtshop.repositories.ProductInfoCustomRepository;
import com.turing.tshirtshop.repositories.ProductRepository;
import com.turing.tshirtshop.repositories.ReviewRepository;
import com.turing.tshirtshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInfoCustomRepository productInfoCustomRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @Cacheable("products")
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

    @Override
    public SearchProductDto searchProductsByCategory(int categoryId, int descriptionLength, int limit, int page) {
        SearchProductDto searchProductDto = new SearchProductDto();
        searchProductDto.setRows(productRepository.searchProductsByCategory(categoryId,descriptionLength,limit,page));
        return searchProductDto;
    }

    @Override
    public SearchProductDto searchProductsByDepartment(int departementId, int descriptionLength, int limit, int page) {
        SearchProductDto searchProductDto = new SearchProductDto();
        searchProductDto.setRows(productRepository.searchProductsByDepartment(departementId,descriptionLength,limit,page));
        return searchProductDto;
    }

    @Override
    public ProductReviewDto searchReviewByProduct(int productId) {
        ProductReviewDto productReviewDto = new ProductReviewDto();
        productReviewDto.setReviews(reviewRepository.searchReviewByProduct(productId));
        return productReviewDto;
    }

    @Override
    public Review save(int productId, Review review) {

        int lastReviewId= reviewRepository.saveReview(review.getCustomerId(),productId,
                review.getReview(),review.getRating());

        return reviewRepository.findById(lastReviewId).orElse(null);
    }
}