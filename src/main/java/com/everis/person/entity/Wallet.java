package com.everis.person.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@Document
public class Wallet {
    @Id
    private UUID id;
    private Person person;
    private BigDecimal amount;
}
