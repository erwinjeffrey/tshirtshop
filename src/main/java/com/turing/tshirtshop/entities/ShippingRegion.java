package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
@Table(name = "shipping_region")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class ShippingRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_region_id")
    private int id;

    @Column(name = "shipping_region")
    private String shippingRegion;

    @JsonSerialize
    @JsonProperty("shipping_region_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonSerialize
    @JsonProperty("shipping_region")
    public String getShippingRegion() {
        return shippingRegion;
    }

    public void setShippingRegion(String shippingRegion) {
        this.shippingRegion = shippingRegion;
    }
}
