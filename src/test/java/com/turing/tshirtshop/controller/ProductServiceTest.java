package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.entities.Product;
import com.turing.tshirtshop.entities.Review;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.repositories.ProductRepository;
import com.turing.tshirtshop.repositories.ReviewRepository;
import com.turing.tshirtshop.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest extends TshirtshopBase{

    @Autowired
    private ProductService productService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void postProductReviewSuccessful(){
        HttpEntity<Customer> review = getHttpEntity("{   \n" +
                "    \"review\": \"this a good product\",\n" +
                "    \"rating\": 5,\n" +
                "    \"customer_id\":1,\n" +
                "    \"created_on\":\"\"\n" +
                "}");

        ResponseEntity<Review> responseEntity = testRestTemplate.postForEntity(
                "/products/1/reviews", review, Review.class);

        Assert.assertEquals(responseEntity.getBody().getRating(), 5);

        reviewRepository.deleteById(responseEntity.getBody().getReviewId());
    }
}
