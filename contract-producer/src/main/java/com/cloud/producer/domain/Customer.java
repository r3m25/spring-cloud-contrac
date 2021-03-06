package com.cloud.producer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String name;
    private String fullName;
    private String phone;

}
