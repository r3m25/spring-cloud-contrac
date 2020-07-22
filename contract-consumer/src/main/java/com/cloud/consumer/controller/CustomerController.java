package com.cloud.consumer.controller;

import com.cloud.consumer.client.domain.CustomerClient;
import com.cloud.consumer.domain.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/test")
public class CustomerController {

    private static String PATH = "http://localhost:8091/customer";

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomer() {

        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(PATH))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CustomerClient> response
                = restTemplate.exchange(requestEntity, CustomerClient.class);

        return ResponseEntity.ok(buildCustomer(Objects.requireNonNull(response.getBody())));
    }

    private Customer buildCustomer(CustomerClient customerClient) {
        return Customer.builder()
                .name(customerClient.getName())
                .lastName(customerClient.getFullName())
                .phone(customerClient.getPhone())
                .build();
    }
}
