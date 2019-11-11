package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.service.EmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSuccessfulEmail(){
        Assert.assertEquals(emailService.emailValidator("jose14@gmail.com"), true);
    }
}
