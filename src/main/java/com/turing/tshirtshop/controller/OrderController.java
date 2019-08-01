package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.custom.OrderIdDto;
import com.turing.tshirtshop.models.OrderDto;
import com.turing.tshirtshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(path = "")
    ResponseEntity<OrderIdDto> createOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }
}
