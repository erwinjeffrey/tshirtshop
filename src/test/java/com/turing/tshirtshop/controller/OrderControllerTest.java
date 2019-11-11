package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.entities.Order;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.repositories.OrderRepository;
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
public class OrderControllerTest extends TshirtshopBase{

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void postingOrderWithoutSigning(){
        HttpEntity<Customer> orders = getHttpEntity("{\n" +
                "\t\"customer_id\": 4,\n" +
                "    \"cart_id\" : \"1\",\n" +
                "    \"shipping_id\" : 1,\n" +
                "    \"tax_id\" : 1\n" +
                "}");

        ResponseEntity<Order> responseEntity = testRestTemplate.postForEntity(
                "/orders", orders, Order.class);

        Assert.assertEquals(403, responseEntity.getStatusCodeValue());
    }

}
