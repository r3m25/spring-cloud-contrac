package com.cloud.consumer.client;

import com.cloud.consumer.client.domain.CustomerClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8090)
class CustomerFeignClientTest {

    private static String PATH = "/customer";



    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnCustomerClient() throws JsonProcessingException {

        String customerJson = objectMapper.writeValueAsString(
                CustomerClient.builder()
                        .name("ruben")
                        .fullName("medina")
                        .build());

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(PATH)).willReturn(
                WireMock.aResponse()
                        .withStatus(200)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .withBody(customerJson)));

        //BDDAssertions.then(customerFeignClient.getCustomer().getName()).isEqualTo("ruben");
    }

}
