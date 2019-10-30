package com.turing.tshirtshop.custom;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class OrderIdDto {

    @Column(name = "order_id")
   private int  orderId;

   @JsonSerialize
   @JsonProperty("order_id")
   public int getOrderId() {
        return orderId;
   }

   public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
