package com.cloud.producer.controller;

import com.cloud.producer.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomers() {
        return ResponseEntity.ok(buildCustomer());
    }

    private Customer buildCustomer()  {
        return Customer.builder()
                .name("user")
                .fullName("fullName")
                .phone("987654321")
                .build();
    }
}
