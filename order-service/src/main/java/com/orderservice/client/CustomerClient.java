package com.orderservice.client;

import com.orderservice.entity.Customer;
import com.orderservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "customer-service", url= "localhost:8083")
public interface CustomerClient {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
