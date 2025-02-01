package com.tech2java.accounts.controller;

import com.tech2java.accounts.dto.CustomerDto;
import com.tech2java.accounts.dto.ErrorResponseDto;
import com.tech2java.accounts.dto.ResponseDto;
import com.tech2java.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountService iAccountService;


    @Tag(
            name = "CRUD REST API for Accounts",
            description = "CRUD REST API:CREATE,UPDATE,FETCH & DELETE"

    )
    @Operation(
            summary = "Create Account REST API",
            description = "API to create new customer and account"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Http Status Internal Server Error",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201","Account Created"));
    }

    @GetMapping("/fetch")
    public  ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){

        CustomerDto customerDto=iAccountService.fetchAccount(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){
       boolean isDeleted= iAccountService.deleteAccount(mobileNumber);
       if (isDeleted) {
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200", "Account Deleted"));
       }else{
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto("417", "Exception Failed"));
       }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@RequestBody CustomerDto customerDto){
        boolean isUpdated=iAccountService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200","Account Updated"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto("417", "Exception Failed"));
        }

    }
}
