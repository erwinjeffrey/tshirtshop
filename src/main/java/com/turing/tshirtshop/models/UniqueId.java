package com.turing.tshirtshop.models;

public class UniqueId {
    private String cart_id;

    public UniqueId(){}
    public UniqueId(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }
}
