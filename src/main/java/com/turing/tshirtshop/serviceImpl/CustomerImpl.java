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
        Customer customerInfo = customerRepository.findById(customerLogin.getCustomerId()).get();
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
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getDayPhone(),
                customer.getEvePhone(),
                customer.getMobPhone()
        );
        Customer updatedCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        updatedCustomer.setPassword(null);
        return  updatedCustomer;
    }

    @Override
    public Customer updateAddress(Customer customer) {
        customerRepository.updateAddress(
                customer.getCustomerId(),
                customer.getFirstAddress(),
                customer.getSecondAddress(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getShippingRegionId());
        Customer updatedCustomer = customerRepository.findById(customer.getCustomerId()).get();
        updatedCustomer.setPassword(null);
        return updatedCustomer;
    }

    @Override
    public Customer updateCreditCard(Customer customer) {
        customerRepository.updateCreditCard(customer.getCustomerId(), customer.getCreditCard());
        Customer updatedCustomer = customerRepository.findById(customer.getCustomerId()).get();
        updatedCustomer.setPassword(null);
        return updatedCustomer;
    }
}
