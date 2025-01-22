package com.tech2java.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountDto {

    @NotEmpty(message = "accountNumber can not be null or empty")
    private Long accountNumber;
    private String branchAddress;
    private String accountType;

}
