package com.turing.tshirtshop.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class OrderDto {
    private char cartId;
    private int shippingId;
    private int taxId;
    private int customerId;

    @JsonSerialize
    @JsonProperty("cart_id")
    public char getCartId() {
        return cartId;
    }

    public void setCartId(char cartId) {
        this.cartId = cartId;
    }

    @JsonSerialize
    @JsonProperty("shipping_id")
    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    @JsonSerialize
    @JsonProperty("tax_id")
    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    @JsonSerialize
    @JsonProperty("customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
