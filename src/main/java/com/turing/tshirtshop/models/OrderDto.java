package com.turing.tshirtshop.models;

public class OrderDto {
    private char cart_id;
    private int shipping_id;
    private int tax_id;
    private int customer_id;

    public char getCart_id() {
        return cart_id;
    }

    public void setCart_id(char cart_id) {
        this.cart_id = cart_id;
    }

    public int getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(int shipping_id) {
        this.shipping_id = shipping_id;
    }

    public int getTax_id() {
        return tax_id;
    }

    public void setTax_id(int tax_id) {
        this.tax_id = tax_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
