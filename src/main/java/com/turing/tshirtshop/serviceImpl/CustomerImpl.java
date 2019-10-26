package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.CustomerLoginInfo;
import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.repositories.CustomerLoginInfoRepository;
import com.turing.tshirtshop.repositories.CustomerRepository;
import com.turing.tshirtshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerLoginInfoRepository customerLoginInfoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public CustomerDto addCustomer(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
     int lastInsertedId = customerRepository.addCustomer(customer.getName(),customer.getEmail(),customer.getPassword());
     Customer customer1 = customerRepository.findById(lastInsertedId).get();
     customer1.setPassword(null);
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

    @Override
    public Customer findCustomer(int customerId) {
        Customer customer = customerRepository.getCustomer(customerId);
        customer.setPassword(null);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerRepository.updateCustomer(
                customer.getCustomer_id(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getDay_phone(),
                customer.getEve_phone(),
                customer.getMob_phone()
        );
        Customer updatedCustomer = customerRepository.findById(customer.getCustomer_id()).orElse(null);
        updatedCustomer.setPassword(null);
        return  updatedCustomer;
    }

    @Override
    public Customer updateAddress(Customer customer) {
        customerRepository.updateAddress(
                customer.getCustomer_id(),
                customer.getAddress_1(),
                customer.getAddress_2(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostal_code(),
                customer.getCountry(),
                customer.getShipping_region_id());
        Customer updatedCustomer = customerRepository.findById(customer.getCustomer_id()).get();
        updatedCustomer.setPassword(null);
        return updatedCustomer;
    }

    @Override
    public Customer updateCreditCard(Customer customer) {
        customerRepository.updateCreditCard(customer.getCustomer_id(), customer.getCredit_card());
        Customer updatedCustomer = customerRepository.findById(customer.getCustomer_id()).get();
        updatedCustomer.setPassword(null);
        return updatedCustomer;
    }
}
