package com.turing.tshirtshop.service;

import com.stripe.Stripe;
import com.turing.tshirtshop.models.StripeDto;
import com.turing.tshirtshop.models.StripeResponse;

public interface StripeService {

    public StripeResponse charge(StripeDto stripe);
}
