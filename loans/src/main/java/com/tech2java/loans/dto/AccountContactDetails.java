package com.tech2java.loans.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")

/*public record AccountContactDetails(String message, Map<String,String> contactDetails, List<String> onCallSupport) {


}*/
@Getter
@Setter
@ToString
public class AccountContactDetails{
    private String message;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;

}
