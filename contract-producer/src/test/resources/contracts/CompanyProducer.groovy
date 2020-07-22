package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("Should return list companies")
    request {
        method('GET')
        urlPath('/companies')
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
                [
                    "name":"Apple",
                    "email": "www.apple.com"
                ],
                [
                     "name":"Google",
                     "email": "www.google.com"
                ]
        ])
    }
}
