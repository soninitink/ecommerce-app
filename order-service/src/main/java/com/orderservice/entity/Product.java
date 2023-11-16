package com.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private Long id;
    private String name;
    private double price;
}
