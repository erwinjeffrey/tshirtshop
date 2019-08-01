package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.CustomerLoginInfo;
import com.turing.tshirtshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "call customer_add(:inName,:inEmail,:inPassword)")
    int addCustomer(@Param("inName") String name, @Param("inEmail") String email,@Param("inPassword") String password);

    @Query(nativeQuery = true, value = "call customer_get_login_info(:inEmail)")
    CustomerLoginInfo customerLoginInfo(@Param("inEmail") String email);

}