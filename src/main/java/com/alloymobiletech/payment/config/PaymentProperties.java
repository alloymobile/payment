package com.alloymobiletech.payment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("payment")
public class PaymentProperties {
    private String secret;
    private String tokenPrefix;
    private String headerString;
    private String stripeApiKey;
}
