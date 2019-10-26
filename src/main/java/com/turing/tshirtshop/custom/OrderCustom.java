package com.turing.tshirtshop.custom;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class OrderCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private double  total_amount;
    private Date created_on;
    private int status;
    private String  name;
    private Date shipped_on;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShipped_on() {
        return shipped_on;
    }

    public void setShipped_on(Date shipped_on) {
        this.shipped_on = shipped_on;
    }
}
