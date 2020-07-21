package com.cloud.consumer.contract;

import static org.hamcrest.Matchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubsMode.LOCAL, ids ="com.cloud:contract-producer:+:stubs:8091")
class CustomerContractTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnCustomer() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/test/customer")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("ruben")))
                .andExpect(jsonPath("$.lastName", is("morales")))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

}
