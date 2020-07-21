package contracts

org.springframework.cloud.contract.spec.Contract.make {

    description("Should return all customer")
    request {
        method('GET')
        urlPath('/customer')
        headers {
            contentType('application/json')
        }
    }
    response {
        status(200)
        headers {
            contentType('application/json')
        }
        body([
                "name": "user",
                "fullName": "fullName",
                "phone": "987654321"
        ])
    }
}
