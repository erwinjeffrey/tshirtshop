package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.CustomerLoginInfo;
import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.repositories.CustomerLoginInfoRepository;
import com.turing.tshirtshop.repositories.CustomerRepository;
import com.turing.tshirtshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerLoginInfoRepository customerLoginInfoRepository;

    @Override
    public CustomerDto addCustomer(Customer customer) {
     int lastInsertedId = customerRepository.addCustomer(customer.getName(),customer.getEmail(),customer.getPassword());
     Customer customer1 = customerRepository.findById(lastInsertedId).get();
     CustomerDto customerDto = new CustomerDto();
     customerDto.setCustomer(customer1);
     return customerDto;
    }

    @Override
    public CustomerDto customerLoginInfo(Customer customer) {
        CustomerLoginInfo customerLogin = customerLoginInfoRepository.customerLoginInfo(customer.getEmail());
        Customer customerInfo = customerRepository.findById(customerLogin.getCustomer_id()).get();
        if(customer.getPassword().equals(customerInfo.getPassword())){
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustomer(customer);
            return customerDto;
        }
       return null;
    }
}
