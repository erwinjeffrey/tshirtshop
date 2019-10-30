package com.turing.tshirtshop.custom;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attribute")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class AttributeCustom {
    @Id
    @Column(name = "attribute_value_id")
    private int attributeValueId;
    @Column(name = "attribute_name")
    private String attributeName;
    @Column(name = "attribute_value")
    private String attributeValue;

    @JsonSerialize
    @JsonProperty("attribute_value_id")
    public int getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(int attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    @JsonSerialize
    @JsonProperty("attribute_name")
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @JsonSerialize
    @JsonProperty("attribute_value")
    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
