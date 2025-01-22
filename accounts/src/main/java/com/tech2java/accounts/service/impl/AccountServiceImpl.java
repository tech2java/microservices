package com.tech2java.accounts.service.impl;

import com.tech2java.accounts.dto.AccountDto;
import com.tech2java.accounts.dto.CustomerDto;
import com.tech2java.accounts.entity.Accounts;
import com.tech2java.accounts.entity.Customer;
import com.tech2java.accounts.exception.CustomerAleadyExistException;
import com.tech2java.accounts.exception.ResourceNotFoundException;
import com.tech2java.accounts.repository.AccountRepository;
import com.tech2java.accounts.repository.CustomerRepository;
import com.tech2java.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {


        Customer customer=new Customer();

        Optional<Customer> customerDtoOptional=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(customerDtoOptional.isPresent()){
            throw new CustomerAleadyExistException("Customer Already exist with Given Mobile Number::"+customerDto.getMobileNumber());
        }

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        //customer.setCreatedBy("TestUser");
       ///customer.setCreatedAt(LocalDateTime.now());
        Customer savedCustomer=customerRepository.save(customer);

        Accounts accounts=new Accounts();
        accounts.setCustomerId(savedCustomer.getCustomerId());
        accounts.setAccountNumber(100000000L+new Random().nextInt(9000000));
        accounts.setAccountType("Savings");
        accounts.setBranchAddress("Hyd");
        //accounts.setCreatedBy("TestUser");
        //accounts.setCreatedAt(LocalDateTime.now());
        accountRepository.save(accounts);


    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {

        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("customer","mobileNumber",mobileNumber));

        Accounts accounts=accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("account","customerId",customer.getCustomerId().toString()));

        CustomerDto customerDto=new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());

        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(accounts.getAccountNumber());
        accountDto.setAccountType(accounts.getAccountType());
        accountDto.setBranchAddress(accounts.getBranchAddress());
        customerDto.setAccountDto(accountDto);

        return customerDto;

    }

    @Override
    public boolean deleteAccount(String mobileNumber) {

        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("customer","mobileNumber",mobileNumber));
        System.out.println("service::deleteAccount---1");
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        System.out.println("service::deleteAccount---2");
        customerRepository.deleteById(customer.getCustomerId());

        return true;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {

        boolean isUpdated=false;

        AccountDto accountDto=customerDto.getAccountDto();
        if(accountDto!=null){
            Accounts accounts=accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(()->new ResourceNotFoundException("Account","account number",accountDto.getAccountNumber().toString()));
            accounts.setBranchAddress(accountDto.getBranchAddress());

            accountRepository.save(accounts);

            Customer customer=customerRepository.findById(accounts.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer","customerID",accounts.getCustomerId().toString()));

            customer.setEmail(customerDto.getEmail());

            customerRepository.save(customer);

            isUpdated=true;



        }
        return isUpdated;
    }
}
