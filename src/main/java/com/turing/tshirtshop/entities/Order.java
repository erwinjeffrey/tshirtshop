package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
@Table(name = "order")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name="orderDetails",
                procedureName = "orders_get_order_details",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inOrderId",type = Integer.class),
                 })
}

)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    private String  attributes;
    @Column(name = "product_name")
    private String productName;
    private int quantity;
    @Column(name = "unit_cost")
    private int unitCost;
    private int subtotal;

    @JsonSerialize
    @JsonProperty("product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @JsonSerialize
    @JsonProperty("product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonSerialize
    @JsonProperty("unit_cost")
    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
