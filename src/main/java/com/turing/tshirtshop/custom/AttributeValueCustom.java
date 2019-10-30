package com.turing.tshirtshop.custom;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class AttributeValueCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_value_id")
    private int attributeValueId;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonSerialize
    @JsonProperty("attribute_value_id")
    public int getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(int attributeValueId) {
        this.attributeValueId = attributeValueId;
    }
}
