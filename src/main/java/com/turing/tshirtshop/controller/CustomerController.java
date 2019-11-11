package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*
     This endpoints allow a user to create a new account.
     */
    @PostMapping(path = "/customers")
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody Customer customer){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri())
                .body(customerService.addCustomer(customer));
    }

    /*@PostMapping(path = "/login")
    public ResponseEntity<CustomerDto> customerLoginInfo(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.customerLoginInfo(customer));
    }*/

    @GetMapping(path = "/customers/{customer_id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("customer_id") int customerId){
        return ResponseEntity.ok(customerService.findCustomer(customerId));
    }

    @PutMapping(path = "/customer")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @PutMapping(path = "/customer/address")
    public ResponseEntity<Customer> updateAddress(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateAddress(customer));
    }

    @PutMapping(path = "/customer/creditCard")
    public ResponseEntity<Customer> updateCreditCard(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCreditCard(customer));
    }
}
