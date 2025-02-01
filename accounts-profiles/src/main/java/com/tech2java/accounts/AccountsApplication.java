package com.tech2java.accounts;

import com.tech2java.accounts.dto.AccountContactDetails;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
		info = @Info(
				title = "Accounts micrservice RESTAPI doc",
				description = "Accounts CRUD operation",
				version="v1",
				contact = @Contact(
						name="v1",
						email="cool@gmail.com",
						url="tech2java.com"
				),
				license = @License(
						name = "Apache2.0",
						url="http://www.apache.com"
				)
		),
		externalDocs=@ExternalDocumentation(
			description = "swagger description..",
			url="https://www.tech2java/swagger-ui.html"
      )
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
@EnableConfigurationProperties(AccountContactDetails.class)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
