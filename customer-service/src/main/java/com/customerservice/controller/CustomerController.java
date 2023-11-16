package com.customerservice.controller;

import com.customerservice.entity.Customer;
import com.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return  customerRepository.save(customer);
    }
}
