package com.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private long id;
    private String name;
    private String email;
    private String address;
    private String zipCode;
}
