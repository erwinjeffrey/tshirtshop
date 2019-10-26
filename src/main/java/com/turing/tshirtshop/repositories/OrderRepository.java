package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.OrderCustom;
import com.turing.tshirtshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(nativeQuery = true, value = "call shopping_cart_create_order(:inCartId,:inCustomerId," +
            ":inShippingId,:inTaxId)")
    int createOrder(@Param("inCartId") char carId, @Param("inCustomerId")
            int customerId, @Param("inShippingId") int shippingId, @Param("inTaxId") int taxId);

    @Query(nativeQuery = true, value = "call orders_get_order_details(:inOrderId)")
    List<Order> findOrderDetails(@Param("inOrderId") int orderId);

    @Query(nativeQuery = true, value = "call orders_get_by_customer_id(:inCustomerId)")
    List<Order>findOrdersByCustomer(@Param("inCustomerId") int customerId);
}