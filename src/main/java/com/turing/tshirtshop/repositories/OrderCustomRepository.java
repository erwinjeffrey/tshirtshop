package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.OrderCustom;
import com.turing.tshirtshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderCustomRepository extends JpaRepository<OrderCustom, Integer> {

    @Query(nativeQuery = true, value = "call orders_get_by_customer_id(:inCustomerId)")
    List<OrderCustom> findOrdersByCustomer(@Param("inCustomerId") int customerId);

    @Query(nativeQuery = true, value = "call orders_get_order_short_details(:inOrderId)")
    OrderCustom findOrderShortDetails(@Param("inOrderId") int orderId);
}
