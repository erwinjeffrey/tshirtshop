package com.turing.tshirtshop.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public abstract class TshirtshopBase {

    MockMvc mockMvc;

    public <T>HttpEntity getHttpEntity(T body){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<T>(body, headers);
    }
}
