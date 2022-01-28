package com.alloymobile.payment.model;

import lombok.Data;

@Data
public class PaymentDTO {
    private String token;
    private Double amount;
    private Currency currency;
}
