package com.cloud.producer.service;

import com.cloud.producer.domain.Company;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyService {

    public List<Company> shouldReturnACompanyList() {
        return Arrays.asList(
                Company.builder().email("www.apple.com").name("Apple").build(),
                Company.builder().email("www.google.com").name("Google").build());
    }

}
