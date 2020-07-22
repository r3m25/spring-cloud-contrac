package com.cloud.producer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {
    private String name;
    private String email;
}
