package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "shipping")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private int shippingId;
    @Column(name = "shipping_type")
    private String shippingType;
    @Column(name = "shipping_cost")
    private double shippingCost;
    @Column(name = "shipping_region_id")
    private int shippingRegionId;

    @JsonSerialize
    @JsonProperty("shipping_id")
    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    @JsonSerialize
    @JsonProperty("shipping_type")
    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    @JsonSerialize
    @JsonProperty("shipping_cost")
    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }


    @JsonSerialize
    @JsonProperty("shipping_region_id")
    public int getShippingRegionId() {
        return shippingRegionId;
    }

    public void setShippingRegionId(int shippingRegionId) {
        this.shippingRegionId = shippingRegionId;
    }
}
