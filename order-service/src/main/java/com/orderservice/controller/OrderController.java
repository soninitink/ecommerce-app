package com.orderservice.controller;

import com.orderservice.client.CustomerClient;
import com.orderservice.client.ProductClient;
import com.orderservice.customeException.ProductNotFoundException;
import com.orderservice.entity.Customer;
import com.orderservice.entity.ProductOrder;
import com.orderservice.entity.Product;
import com.orderservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductClient productClient;
    @Autowired
    CustomerClient customerClient;
    @GetMapping("/{id}")
    public ProductOrder getOrder(@PathVariable Long id){
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    @CircuitBreaker(name = " order-service", fallbackMethod = "noOrderCreated")
    public ProductOrder createOrder(@RequestBody ProductOrder order) {
        Product product = productClient.getProductById(order.getProductId());
        Customer customer = customerClient.getCustomerById(order.getCustomerId());
        if (product != null && customer != null) {
            return orderRepository.save(order);
        } else {
            throw new ProductNotFoundException();
        }
    }
    public ProductOrder noOrderCreated(ProductOrder order, Exception e){
        return new ProductOrder();
    }
}
