package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import org.springframework.http.HttpHeaders;

public interface CustomerService {

    CustomerDto addCustomer(Customer customer);
    CustomerDto customerLoginInfo(Customer customer);
    Customer findCustomer(int customerId);
    Customer updateCustomer(Customer customer);
    Customer updateAddress(Customer customer);
    Customer updateCreditCard(Customer customer);
    boolean isEmailAlreadyInUse(String email);
}
