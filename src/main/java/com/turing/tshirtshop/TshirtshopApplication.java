package com.turing.tshirtshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TshirtshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TshirtshopApplication.class, args);
	}

}
