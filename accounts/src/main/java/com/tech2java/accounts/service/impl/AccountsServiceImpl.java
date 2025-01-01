package com.tech2java.accounts.service.impl;

import com.tech2java.accounts.constants.AccountsConstants;
import com.tech2java.accounts.dto.AccountsDto;
import com.tech2java.accounts.dto.CustomerDto;
import com.tech2java.accounts.entity.Accounts;
import com.tech2java.accounts.entity.Customer;
import com.tech2java.accounts.exception.CustomerAlreadyExistException;
import com.tech2java.accounts.exception.ResourceNotFoundException;
import com.tech2java.accounts.mapper.AccountsMapper;
import com.tech2java.accounts.mapper.CustomerMapper;
import com.tech2java.accounts.repository.AccountsRepository;
import com.tech2java.accounts.repository.CustomerRepository;
import com.tech2java.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer=CustomerMapper.mapToCustomer(customerDto,new Customer());

        Optional<Customer> returnCustomer =customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(returnCustomer.isPresent()){
            throw  new CustomerAlreadyExistException("Customer Already existed with provided mobile number:"+customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {

        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("customer","mobileNumber",mobileNumber)
        );

        Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()->new ResourceNotFoundException("account","customerId",customer.getCustomerId().toString())
        );

        CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));

        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {

        boolean isUpdated=false;

        AccountsDto accountsDto=customerDto.getAccountsDto();

        if(accountsDto!=null) {
            Accounts accounts=accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    ()->new ResourceNotFoundException("Account","AccountNumber",accountsDto.getAccountNumber().toString())
            );

            AccountsMapper.mapToAccounts(accountsDto,accounts);
            //Saving Accounts
            accountsRepository.save(accounts);

            Long customerId=accounts.getCustomerId();

            Customer customer=customerRepository.findById(customerId).orElseThrow(
                    ()->new ResourceNotFoundException("Customer","CutomerId",customerId.toString())
            );

            CustomerMapper.mapToCustomer(customerDto,customer);
            //Saving Customer
            customerRepository.save(customer);
            isUpdated=true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {

        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    private Accounts createAccount(Customer customer){
        Accounts accounts=new Accounts();
        long accountNo=1000000000L+new Random().nextInt(900000000);
        accounts.setCustomerId(customer.getCustomerId());
        accounts.setAccountNumber(accountNo);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);
        accounts.setCreatedBy("Anonymous");
        accounts.setCreatedAt(LocalDateTime.now());
        return accounts;
    }




}
