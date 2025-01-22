package com.tech2java.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be null or empty")
    private String name;
    @NotEmpty(message = "Email can not be null or empty")
    private String email;
    @NotEmpty(message = "mobile number can not be null or empty")
    private String mobileNumber;

    private AccountDto accountDto;
}
