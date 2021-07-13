package com.everis.person.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
@Builder
public class Person {
    @Id
    private String dni;
    private String name;
    private String phoneNumber;
    private String phoneImei;
    private String email;
}
