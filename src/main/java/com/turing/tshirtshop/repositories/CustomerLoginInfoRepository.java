package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.CustomerLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerLoginInfoRepository extends JpaRepository<CustomerLoginInfo, Integer> {
    @Query(nativeQuery = true, value = "call customer_get_login_info(:inEmail)")
    CustomerLoginInfo customerLoginInfo(@Param("inEmail") String email);
}
