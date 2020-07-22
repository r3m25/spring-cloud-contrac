package com.cloud.producer.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.cloud.producer.service.CompanyService;
import com.cloud.producer.domain.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping(value = "/companies", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> shouldReturnCompanyList() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.shouldReturnACompanyList());
    }

}
