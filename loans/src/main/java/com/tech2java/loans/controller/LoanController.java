package com.tech2java.loans.controller;

import com.tech2java.loans.client.AccountsFeignClient;
import com.tech2java.loans.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/loans/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {

    @Autowired
    private AccountsFeignClient accountsFeignClient;

    @GetMapping("/getDetails")
    public ResponseEntity<CustomerDto> getDetails(@RequestParam String mobileNumber){
        System.out.println("Inside Loans Controller-----getDetails method!!!");

        CustomerDto customerDto=accountsFeignClient.fetchAccountDetails(mobileNumber).getBody();
        System.out.println("customerDto::"+customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
}
