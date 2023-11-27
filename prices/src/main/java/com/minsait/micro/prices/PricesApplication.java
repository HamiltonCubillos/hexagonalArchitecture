package com.minsait.micro.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PricesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}
}
