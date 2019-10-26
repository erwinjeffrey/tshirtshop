package com.turing.tshirtshop.custom;
import com.turing.tshirtshop.entities.Order;

import java.util.List;

public class OrderDetailsCustom {

    //@SerializedName("order_items")
    private int order_id;

   // @SerializedName("order_items")
    private List<Order> order_items;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public List<Order> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<Order> order_items) {
        this.order_items = order_items;
    }
}
