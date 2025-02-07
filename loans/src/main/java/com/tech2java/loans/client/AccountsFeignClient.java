package com.tech2java.loans.client;


import com.tech2java.loans.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="accounts")
public interface AccountsFeignClient {


    @GetMapping(value = "/api/fetch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber);
}
