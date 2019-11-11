package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.service.TaxService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaxServiceTest {

    @Autowired
    private TaxService taxService;

    @Test
    public void findAllTaxesSuccessful(){
       Assert.assertTrue( taxService.findAll().size() > 0);
    }

    @Test
    public void findTaxSuccessful(){
        Assert.assertEquals(taxService.findTaxById(1).getTaxType(),"Sales Tax at 8.5%");
    }
}
