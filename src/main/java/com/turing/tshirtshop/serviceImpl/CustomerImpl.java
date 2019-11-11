package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.CustomerLoginInfo;
import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.exceptions.GlobalExceptionHandler;
import com.turing.tshirtshop.models.CustomerDto;
import com.turing.tshirtshop.repositories.CustomerLoginInfoRepository;
import com.turing.tshirtshop.repositories.CustomerRepository;
import com.turing.tshirtshop.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
public class CustomerImpl implements CustomerService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerLoginInfoRepository customerLoginInfoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public CustomerDto addCustomer(Customer customer) {
        LOG.debug("Adding Customer : " + customer);

        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        int lastInsertedId = customerRepository.addCustomer(customer.getName(), customer.getEmail(), customer.getPassword());
        Customer customer1 = customerRepository.findById(lastInsertedId).get();

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomer(customer1);
        return customerDto;
    }

    @Override
    public CustomerDto customerLoginInfo(Customer customer) {
        LOG.debug("Logging Customer : " + customer);
        CustomerLoginInfo customerLogin = customerLoginInfoRepository.customerLoginInfo(customer.getEmail());
        Customer customerInfo = customerRepository.findById(customerLogin.getCustomerId()).get();
        if (customer.getPassword().equals(customerInfo.getPassword())) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustomer(customer);
            return customerDto;
        }
        return null;
    }

    @Override
    public Customer findCustomer(int customerId) {
        LOG.debug("finding Customer : " + customerId);
        Customer customer = customerRepository.getCustomer(customerId);
        customer.setPassword(null);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        LOG.debug("Updated Customer : " + customer);
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
        return updatedCustomer;
    }

    @Override
    public Customer updateAddress(Customer customer) {
        LOG.debug("Updated address : " + customer);
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
        return updatedCustomer;
    }

    @Override
    public Customer updateCreditCard(Customer customer) {
        customerRepository.updateCreditCard(customer.getCustomerId(), customer.getCreditCard());
        Customer updatedCustomer = customerRepository.findById(customer.getCustomerId()).get();
        return updatedCustomer;
    }

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        if (customerRepository.findByEmail(email) == null) {
            return false;
        }
        return true;
    }

    private void autoLogin(String username, String password){
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
              new UsernamePasswordAuthenticationToken(username,password);

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(usernamePasswordAuthenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

    }

}
