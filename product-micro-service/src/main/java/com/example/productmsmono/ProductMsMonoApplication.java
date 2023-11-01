package com.example.productmsmono;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;



@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
//@EnableSwagger2
@EnableEurekaClient
@OpenAPIDefinition
public class ProductMsMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsMonoApplication.class, args);
	}
	
//	public Docket swaggerconf() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com"))
//				.build().apiInfo(apiDetails());
//	}
//	
//	private ApiInfo apiDetails() {
//		return new ApiInfo("product API Doc"
//				,"API for CRUD operatioins on product",
//				"1.3.4",
//				"For Internal user only",
//				new springfox.documentation.service.Contact("Ankit", "http://www.google.com","connect@ankit.com"),
//				"API License",
//				"https://www.google.com",
//				Collections.emptyList());
//	}

}
