package com.turing.tshirtshop.custom;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
public class AttributeValueCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attribute_value_id;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getAttribute_value_id() {
        return attribute_value_id;
    }

    public void setAttribute_value_id(int attribute_value_id) {
        this.attribute_value_id = attribute_value_id;
    }
}
