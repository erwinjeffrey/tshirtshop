package com.turing.tshirtshop.service;

import com.turing.tshirtshop.custom.OrderIdDto;
import com.turing.tshirtshop.models.OrderDto;

public interface OrderService {
    OrderIdDto createOrder(OrderDto orderDto);
}