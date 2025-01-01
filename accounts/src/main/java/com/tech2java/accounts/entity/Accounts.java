package com.tech2java.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity{

    private Long customerId;
    //not adding GeneratedValue , we will generate account number manually
    @Id
    private Long accountNumber;
    private String accountType;
    private String branchAddress;

}