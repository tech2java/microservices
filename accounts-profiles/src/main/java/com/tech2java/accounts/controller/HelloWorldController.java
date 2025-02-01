package com.tech2java.accounts.controller;

import com.tech2java.accounts.dto.AccountContactDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${accounts.message}")
    private String message;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountContactDetails accountContactDetails;

    @GetMapping("/hello")
    public String sayHello(){

        System.out.println(environment.getProperty("JAVA_HOME"));
        System.out.println(environment.getProperty("accounts.message"));
        System.out.println("=============================================");

        System.out.println(accountContactDetails);
        return "Hello World!" + message;
    }
}
