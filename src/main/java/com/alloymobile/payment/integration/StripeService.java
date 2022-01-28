package com.alloymobile.payment.integration;

import com.alloymobile.payment.config.PaymentProperties;
import com.alloymobile.payment.exception.InternalServerException;
import com.alloymobile.payment.model.PaymentDTO;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripeService {

    @Autowired
    public StripeService(PaymentProperties properties) {
        Stripe.apiKey = properties.getStripeApiKey();
    }


    public Charge chargeCreditCard(PaymentDTO paymentDTO){
        try{
            Map<String, Object> chargeParams = new HashMap<String, Object>();
            chargeParams.put("amount", (int)(paymentDTO.getAmount() * 100));
            chargeParams.put("currency", paymentDTO.getCurrency());
            chargeParams.put("source", paymentDTO.getToken());
            Charge charge = Charge.create(chargeParams);
            return charge;
        }catch(InternalServerException | AuthenticationException | InvalidRequestException | APIConnectionException | CardException | APIException e){
            throw new InternalServerException("Can not charge card try again later");
        }
    }
}

