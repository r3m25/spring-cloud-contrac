package com.cloud.consumer.controller;

import com.cloud.consumer.client.domain.CompanyClient;
import com.cloud.consumer.domain.Company;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
public class CompanyController {

    private static String PATH = "http://localhost:8091/companies";

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getCustomer() {

        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(PATH))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CompanyClient[]> response = restTemplate.exchange(requestEntity, CompanyClient[].class);

        return ResponseEntity.ok().body(Stream.of(Objects.requireNonNull(response.getBody()))
                .filter(Objects::nonNull)
                .map(companyClient ->
                        Company.builder()
                                .name(companyClient.getName())
                                .email(companyClient.getEmail())
                                .build())
                .collect(Collectors.toList()));
    }
}
