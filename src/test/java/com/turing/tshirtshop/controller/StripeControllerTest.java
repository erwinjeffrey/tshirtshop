package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.models.StripeDto;
import com.turing.tshirtshop.models.StripeResponse;
import com.turing.tshirtshop.service.StripeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StripeControllerTest extends TshirtshopBase{

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void chargeTestWithoutSigning(){
        HttpEntity<StripeDto> stripe = getHttpEntity("{\n" +
                "    \"order_id\" : 3,\n" +
                "    \"email\":\"erwinjefly@gmail.com\",\n" +
                "    \"description\" : \"Refrigerator\",\n" +
                "    \"amount\" : 100,\n" +
                "    \"currency\" : \"USD\"\n" +
                "}");

        ResponseEntity<StripeResponse> responseEntity = testRestTemplate.postForEntity(
                "/stripe/charge",stripe , StripeResponse.class);

        Assert.assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

}
