# spring-cloud-contrac

In this sampple you can see a useful implementation with spring cloud contract. There are two projects, producer and consumer.

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
