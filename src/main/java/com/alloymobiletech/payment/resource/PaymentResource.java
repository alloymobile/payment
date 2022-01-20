package com.alloymobiletech.payment.resource;

import com.alloymobiletech.payment.model.PaymentDTO;
import com.alloymobiletech.payment.model.ResponseDTO;
import com.alloymobiletech.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Get payment API", description = "The API is used to get payments from stripe")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping(value = "/api/v1/payment",consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseDTO> sendSms(@RequestBody PaymentDTO paymentDTO){
        return paymentService.getPayment(paymentDTO);
    }
}
