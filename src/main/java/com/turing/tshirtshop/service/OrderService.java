package com.turing.tshirtshop.service;

import com.turing.tshirtshop.custom.OrderCustom;
import com.turing.tshirtshop.custom.OrderDetailsCustom;
import com.turing.tshirtshop.custom.OrderIdDto;
import com.turing.tshirtshop.models.OrderDto;

import java.util.List;

public interface OrderService {
    OrderIdDto createOrder(OrderDto orderDto);
    OrderDetailsCustom findOrderDetails(int orderId);
    List<OrderCustom> findOrdersByCustomer(int customerId);
    OrderCustom findOrderShortDetails(int orderId);
}