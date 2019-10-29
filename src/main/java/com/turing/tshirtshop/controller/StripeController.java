package com.turing.tshirtshop.controller;

import com.stripe.Stripe;
import com.turing.tshirtshop.models.StripeDto;
import com.turing.tshirtshop.models.StripeResponse;
import com.turing.tshirtshop.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/stripe")
public class StripeController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/charge")
    public ResponseEntity<StripeResponse> charge(@RequestBody StripeDto stripe){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri())
                .body(stripeService.charge(stripe));
    }

}
