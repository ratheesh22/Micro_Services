package com.cognizant.exchange.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CurrencyExchange {

    @Id
    private Long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private  String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
