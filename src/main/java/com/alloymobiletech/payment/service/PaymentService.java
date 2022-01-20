package com.alloymobiletech.payment.service;

import com.alloymobiletech.payment.integration.StripeService;
import com.alloymobiletech.payment.model.PaymentDTO;
import com.alloymobiletech.payment.model.ResponseDTO;
import com.stripe.model.Charge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final StripeService stripeService;

    public PaymentService(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    public ResponseEntity<ResponseDTO> getPayment(PaymentDTO paymentDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        Charge charge = this.stripeService.chargeCreditCard(paymentDTO);
        responseDTO.setMessage(charge.getDescription());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
