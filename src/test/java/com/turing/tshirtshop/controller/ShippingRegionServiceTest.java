package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.service.ShippingRegionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShippingRegionServiceTest {

    @Autowired
    private ShippingRegionService shippingRegionService;

    @Test
    public void  findShippingRegionsSuccessful(){
        Assert.assertEquals(shippingRegionService.findShippingRegions().size(), 4);
    }
}
