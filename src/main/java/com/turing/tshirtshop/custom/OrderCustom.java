package com.turing.tshirtshop.custom;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class OrderCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "created_on")
    private Date createdOn;
    private int status;
    private String name;
    @Column(name = "shipped_on")
    private Date shippedOn;

    @JsonSerialize
    @JsonProperty("order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @JsonSerialize
    @JsonProperty("total_amount")
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonSerialize
    @JsonProperty("created_on")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize
    @JsonProperty("shipped_on")
    public Date getShippedOn() {
        return shippedOn;
    }

    public void setShippedOn(Date shippedOn) {
        this.shippedOn = shippedOn;
    }
}
