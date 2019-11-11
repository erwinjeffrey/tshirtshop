package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.turing.tshirtshop.customValidation.UniqueEmail;
import com.turing.tshirtshop.customValidation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customer")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name="updateAccount",
                procedureName = "customer_update_account",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCustomerId",type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inName",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inEmail",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inPassword",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inDayPhone",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inEvePhone",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inMobPhone",type = String.class)
                }),
        @NamedStoredProcedureQuery(name="updateAddress",
                procedureName = "customer_update_address",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCustomerId",type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inAddress1",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inAddress2",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCity",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inRegion",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inPostalCode",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCountry",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inShippingRegionId",type = Integer.class)
                }),
        @NamedStoredProcedureQuery(name="updateCreditCard",
                procedureName = "customer_update_credit_card",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCustomerId",type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCreditCard",type = String.class),
                })

        }

)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    private String name;

    @UniqueEmail
    @Email(message = "The email is invalid")
    @NotEmpty(message = "The field email is required")
    @ValidEmail
    private String email;

    @Size(min = 5,max = 10, message = "Password is invalid: must be between 5 and 10")
    private String password;

    @Column(name = "credit_card")
    @Size(min = 16,max = 16, message = "This is an invalid Credit Card: must have 16 digits")
    private String creditCard;

    @Column(name = "address_1")
    private String firstAddress;

    @Column(name = "address_2")
    private String secondAddress;
    private String city;
    private String region;

    @Column(name = "postal_code")
    private String postalCode;
    private String country;

    @Column(name = "shipping_region_id")
    //@Pattern(regexp = "\\d+", message = "The Shipping Region ID is not number" )
    private int shippingRegionId;

    @Column(name = "day_phone")
    //@NotNull
    //@Pattern(regexp = "\\d+", message = "This is an invalid phone number" )
    private String dayPhone;

    @Column(name = "eve_phone")
   // @Pattern(regexp = "\\d+", message = "This is an invalid phone number" )
    private String evePhone;

    @Column(name = "mob_phone")
   // @Pattern(regexp = "\\d+", message = "This is an invalid phone number" )
    private String mobPhone;

    @JsonSerialize
    @JsonProperty("customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @JsonSerialize
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonSerialize
    @JsonProperty("credit_card")
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @JsonSerialize
    @JsonProperty("address_1")
    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    @JsonSerialize
    @JsonProperty("address_2")
    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    @JsonSerialize
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonSerialize
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @JsonSerialize
    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonSerialize
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonSerialize
    @JsonProperty("shipping_region_id")
    public int getShippingRegionId() {
        return shippingRegionId;
    }

    public void setShippingRegionId(int shippingRegionId) {
        this.shippingRegionId = shippingRegionId;
    }

    @JsonSerialize
    @JsonProperty("day_phone")
    public String getDayPhone() {
        return dayPhone;
    }

    public void setDayPhone(String dayPhone) {
        this.dayPhone = dayPhone;
    }

    @JsonSerialize
    @JsonProperty("eve_phone")
    public String getEvePhone() {
        return evePhone;
    }

    public void setEvePhone(String evePhone) {
        this.evePhone = evePhone;
    }

    @JsonSerialize
    @JsonProperty("mob_phone")
    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }
}
