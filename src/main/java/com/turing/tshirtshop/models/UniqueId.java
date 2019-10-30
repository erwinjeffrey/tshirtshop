package com.turing.tshirtshop.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class UniqueId {
    private String cartId;

    public UniqueId(){}

    public UniqueId(String cartId) {
        this.cartId = cartId;
    }

    @JsonSerialize
    @JsonProperty("cart_id")
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }


}
