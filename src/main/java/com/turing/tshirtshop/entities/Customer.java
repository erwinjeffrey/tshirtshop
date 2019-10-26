package com.turing.tshirtshop.entities;

import javax.persistence.*;

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

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String name;
    private String email;
    private String password;
    private String credit_card;
    private String address_1;
    private String address_2;
    private String city;
    private String region;
    private String postal_code;
    private String country;
    private int shipping_region_id;
    private String day_phone;
    private String eve_phone;
    private String mob_phone;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getShipping_region_id() {
        return shipping_region_id;
    }

    public void setShipping_region_id(int shipping_region_id) {
        this.shipping_region_id = shipping_region_id;
    }

    public String getDay_phone() {
        return day_phone;
    }

    public void setDay_phone(String day_phone) {
        this.day_phone = day_phone;
    }

    public String getEve_phone() {
        return eve_phone;
    }

    public void setEve_phone(String eve_phone) {
        this.eve_phone = eve_phone;
    }

    public String getMob_phone() {
        return mob_phone;
    }

    public void setMob_phone(String mob_phone) {
        this.mob_phone = mob_phone;
    }
}
