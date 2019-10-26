package com.turing.tshirtshop.entities;

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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String  attributes;
    private String product_name;
    private int quantity;
    private int unit_cost;
    private int subtotal;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(int unit_cost) {
        this.unit_cost = unit_cost;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
