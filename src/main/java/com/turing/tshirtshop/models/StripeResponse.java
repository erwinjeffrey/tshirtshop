package com.turing.tshirtshop.models;

public class StripeResponse {
    private String message;

    public StripeResponse(){}
    public StripeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
