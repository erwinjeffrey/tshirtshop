package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest extends  TshirtshopBase{

    @Mock
    private CustomerController customerController;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Before
    public void setup() throws  Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testCustomerRegistrationSuccessful() throws  Exception {
        HttpEntity<Customer> customer = getHttpEntity("{\n" +
                "    \"name\": \"maria\",\n" +
                "     \"email\": \"mario016@gmail.com\",\n" +
                "     \"password\": \"admin123\"\n" +
                "}");

        ResponseEntity<CustomerDto> responseEntity = testRestTemplate.postForEntity(
                "/customers", customer, CustomerDto.class);


        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
        Assert.assertEquals("mario016@gmail.com", responseEntity.getBody().getCustomer().getEmail());

        // cleanup the user
        customerRepository.deleteById(responseEntity.getBody().getCustomer().getCustomerId());
    }

}
