package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
@Table(name = "tax")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tax_id")
    private int taxId;
    @Column(name="tax_type")
    private String taxType;
    @Column(name="tax_percentage")
    private double taxPercentage;

    @JsonSerialize
    @JsonProperty("tax_id")
    public int getTaxId() {
        return taxId;
    }


    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    @JsonSerialize
    @JsonProperty("tax_type")
    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    @JsonSerialize
    @JsonProperty("tax_percentage")
    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
