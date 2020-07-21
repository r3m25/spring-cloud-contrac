# spring-cloud-contrac

In this sampple you can see a useful implementation with spring cloud contract. In this repo you can find two projects, producer and consumer.

## Getting Started

### Producer

to start work with Spring Cloud Contract in producer side, you have to add in your pom.xml this dependency below:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-contract-verifier</artifactId>
    <scope>test</scope>
</dependency>
```

#### Your contract test example

create this contract in java/test/contracts path.

```
package contracts

org.springframework.cloud.contract.spec.Contract.make {

    description("Should return all customer")
    request {
        method('GET')
        urlPath('/example')
        headers {
            contentType('application/json')
        }
    }
    response {
        status(200)
        headers {
            contentType('application/json')
        }
        body("""
              {
                "name": "user",
                "fullName": "fullName",
                "phone": "987654321"
              }
        """)
    }
}
```

after create your contract, if you're using maven, you have to execute this commad:

```
mvn clean install -DskipTests 
```

this command generate a stubs jar in target/ folder and mapping wiremock in target/stubs/* 

### Consumer

After to create your producer side, you can use Spring Cloud Contract Stub Runner in the integration tests to get a running WireMock instance or messaging route that simulates the actual service.

To get started, add the dependency to Spring Cloud Contract Stub Runner, as follows:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-contract-stub-runner</artifactId>
    <scope>test</scope>
</dependency>
```

#### Your test consumer stubs

These anotation you must use when define a test contract:

```
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubsMode.LOCAL, ids ="com.cloud:contract-producer:+:stubs:8091")
class ContractTestExample { 

    // your test code.

}

```

When you use @AutoConfigureStubRunner anotation, it looks for a stub jar that has been generetaed since producer side in repository jar, for example: 

* if you are working in local env and you are unisig .m2, you should use StubsMode.LOCAL.

* if you are unsing a remote repo like Artifactory for example, you should use StubsMode.REMOTE.




