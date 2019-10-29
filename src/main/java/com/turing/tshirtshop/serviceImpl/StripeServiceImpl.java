package com.turing.tshirtshop.serviceImpl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.turing.tshirtshop.models.StripeDto;
import com.turing.tshirtshop.models.StripeResponse;
import com.turing.tshirtshop.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeServiceImpl implements StripeService {

    @Override
    public StripeResponse charge(StripeDto stripe) {

        try{
            Stripe.apiKey = "sk_test_rtmalDbyilVmlwfLJRKmmKDD00ugbqSNfQ";

            Map<String, Object> params = new HashMap<>();
            params.put("amount",stripe.getAmount());
            params.put("receipt_email",stripe.getEmail());
            //params.put("order",stripe.getOrderId());
            params.put("currency",stripe.getCurrency());
            params.put("description","Turing Store charge");
            params.put("source", "tok_mastercard");

            Charge charge = Charge.create(params);
            return new StripeResponse(charge.getOutcome().getSellerMessage());
        }catch (StripeException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
