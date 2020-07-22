package com.cloud.consumer.contract;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids ="com.cloud:contract-producer:+:stubs:8091")
class CompanyContractTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnCompanies() throws Exception {

        String json = "[{\"name\":\"Apple\",\"email\":\"www.apple.com\"},{\"name\":\"Google\",\"email\":\"www.google.com\"}]";

        mockMvc.perform(MockMvcRequestBuilders.get("/test/companies")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}
