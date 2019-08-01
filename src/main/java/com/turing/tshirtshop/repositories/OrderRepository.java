package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(nativeQuery = true, value = "call shopping_cart_create_order(:inCartId,:inCustomerId," +
            ":inShippingId,:inTaxId)")
    int createOrder(@Param("inCartId") char carId, @Param("inCustomerId")
            int customerId, @Param("inShippingId") int shippingId, @Param("inTaxId") int taxId);
}