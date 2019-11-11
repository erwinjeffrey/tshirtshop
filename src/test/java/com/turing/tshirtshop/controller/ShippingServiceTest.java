package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.repositories.ShippingRepository;
import com.turing.tshirtshop.service.ShippingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShippingServiceTest {

    @Autowired
    private ShippingRepository shippingRepository;

    @Test
    public void findShippingTypesSuccessful(){
        Assert.assertEquals(shippingRepository.findAll().size(), 7);
    }
}
