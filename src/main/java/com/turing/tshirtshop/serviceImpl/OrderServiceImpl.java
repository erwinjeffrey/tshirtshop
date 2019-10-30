package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.OrderCustom;
import com.turing.tshirtshop.custom.OrderDetailsCustom;
import com.turing.tshirtshop.custom.OrderIdDto;
import com.turing.tshirtshop.entities.Order;
import com.turing.tshirtshop.models.OrderDto;
import com.turing.tshirtshop.repositories.OrderCustomRepository;
import com.turing.tshirtshop.repositories.OrderRepository;
import com.turing.tshirtshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCustomRepository orderCustomRepository;

    @Override
    public OrderIdDto createOrder(OrderDto orderDto) {
        OrderIdDto orderIdDto = new OrderIdDto();

        orderIdDto.setOrderId(orderRepository.createOrder(orderDto.getCartId(),orderDto.getCustomerId(),
                orderDto.getShippingId(),orderDto.getTaxId()));
        return orderIdDto;
    }

    @Override
    public OrderDetailsCustom findOrderDetails(int orderId) {
        List<Order> orders = orderRepository.findOrderDetails(orderId);
        OrderDetailsCustom orderDetailsCustom = new OrderDetailsCustom();
        orderDetailsCustom.setOrderId(orderId);
        orderDetailsCustom.setOrderItems(orders);
        return orderDetailsCustom;
    }

    @Override
    public List<OrderCustom> findOrdersByCustomer(int customerId) {
       return orderCustomRepository.findOrdersByCustomer(customerId);
    }

    @Override
    public OrderCustom findOrderShortDetails(int orderId) {
        return orderCustomRepository.findOrderShortDetails(orderId);
    }


}
