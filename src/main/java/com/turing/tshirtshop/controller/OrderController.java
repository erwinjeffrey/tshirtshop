package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.custom.OrderCustom;
import com.turing.tshirtshop.custom.OrderDetailsCustom;
import com.turing.tshirtshop.custom.OrderIdDto;
import com.turing.tshirtshop.models.OrderDto;
import com.turing.tshirtshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "")
    public ResponseEntity<OrderIdDto> createOrder(@Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderDetailsCustom> findOrderDetails(@PathVariable("orderId") int orderId){
        return ResponseEntity.ok(orderService.findOrderDetails(orderId));
    }

    @GetMapping(path = "/inCustomer/{customerId}")
    public ResponseEntity<List<OrderCustom>> findOrdersByCustomer(@PathVariable("customerId") int customerId){
        return ResponseEntity.ok(orderService.findOrdersByCustomer(customerId));
    }

    @GetMapping(path = "/shortDetail/{orderId}")
    public ResponseEntity<OrderCustom> findOrderShortDetails(@PathVariable("orderId") int orderId){
        return ResponseEntity.ok(orderService.findOrderShortDetails(orderId));
    }
}
