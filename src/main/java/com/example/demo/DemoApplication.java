package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.access.expression.SecurityExpressionHandler;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		context.getBean(PostProcess.class)
		.validateSchema()
		.intitDefaultAccount();
	}
}
