package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*
     This endpoints allow a user to create a new account.
     */
    @PostMapping(path = "")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<CustomerDto> customerLoginInfo(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.customerLoginInfo(customer));
    }

}
