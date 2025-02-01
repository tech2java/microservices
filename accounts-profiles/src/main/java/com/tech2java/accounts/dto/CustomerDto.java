package com.tech2java.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(
        name = "Customer",
        description = "schema to hold customer & account information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Name of the Customer",
            example = "Robin"
    )
    @NotEmpty(message = "Name can not be null or empty")
    private String name;
    @NotEmpty(message = "Email can not be null or empty")
    private String email;
    @NotEmpty(message = "mobile number can not be null or empty")
    private String mobileNumber;

    private AccountDto accountDto;
}
