package com.cloud.producer.base;

import com.cloud.producer.controller.CompanyController;
import com.cloud.producer.controller.CustomerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseClass {

    @Autowired
    private CustomerController customerController;

    @Autowired
    private CompanyController companyController;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(customerController, companyController);
    }

}
