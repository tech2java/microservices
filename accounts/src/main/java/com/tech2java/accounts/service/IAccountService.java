package com.tech2java.accounts.service;

import com.tech2java.accounts.dto.AccountDto;
import com.tech2java.accounts.dto.CustomerDto;
import com.tech2java.accounts.entity.Accounts;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean deleteAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);


}
