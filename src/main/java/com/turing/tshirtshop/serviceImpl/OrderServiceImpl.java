package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.OrderIdDto;
import com.turing.tshirtshop.models.OrderDto;
import com.turing.tshirtshop.repositories.OrderRepository;
import com.turing.tshirtshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderIdDto createOrder(OrderDto orderDto) {
        OrderIdDto orderIdDto = new OrderIdDto();

        orderIdDto.setOrder_id(orderRepository.createOrder(orderDto.getCart_id(),orderDto.getCustomer_id(),
                orderDto.getShipping_id(),orderDto.getTax_id()));
        return orderIdDto;
    }
}
