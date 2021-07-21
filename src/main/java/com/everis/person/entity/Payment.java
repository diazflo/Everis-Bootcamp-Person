package com.everis.person.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Document
@Builder
public class Payment {
    @Id
    private UUID id;
    private Person personRec;
    private Date createDate;
    private BigDecimal amountPayment;
}
