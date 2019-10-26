package com.turing.tshirtshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    private String cart_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;
    private String attributes;
    private int product_id;
    private int quantity;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
