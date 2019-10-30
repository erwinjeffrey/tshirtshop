package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.CustomerLoginInfo;
import com.turing.tshirtshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "call customer_add(:inName,:inEmail,:inPassword)")
    int addCustomer(@Param("inName") String name, @Param("inEmail") String email,@Param("inPassword") String password);

    Customer findByEmail(String email);

    @Query(nativeQuery = true, value = "call customer_get_customer(:inCustomerId)")
    Customer getCustomer(@Param("inCustomerId") int customerId);

    @Procedure(name="updateAccount")
    void updateCustomer(@Param("inCustomerId") int customerId, @Param("inName") String name,
                            @Param("inEmail") String email, @Param("inPassword") String password,
                            @Param("inDayPhone") String dayPhone, @Param("inEvePhone") String evePhone,
                            @Param("inMobPhone") String mobPhone);

    @Procedure(name="updateAddress")
    void updateAddress(@Param("inCustomerId") int customerId, @Param("inAddress1") String firstAddress,
                       @Param("inAddress2") String secondAddress, @Param("inCity") String city,
                       @Param("inRegion") String region, @Param("inPostalCode") String postalCode,
                       @Param("inCountry") String country,@Param("inShippingRegionId") int shippingRegionId);

    @Procedure(name = "updateCreditCard")
    void updateCreditCard(@Param("inCustomerId") int customerId, @Param("inCreditCard") String creditCard);
}