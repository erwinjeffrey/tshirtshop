package com.turing.tshirtshop.custom;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.turing.tshirtshop.entities.Order;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class OrderDetailsCustom {


    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_items")
    private List<Order> orderItems;

    @JsonSerialize
    @JsonProperty("order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @JsonSerialize
    @JsonProperty("order_items")
    public List<Order> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Order> orderItems) {
        this.orderItems = orderItems;
    }
}
