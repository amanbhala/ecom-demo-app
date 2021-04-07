package com.demoapplication.demoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// @ComponentScan
@SpringBootApplication
public class DemoapplicationApplication extends SpringBootServletInitializer{

	// @Override
	// protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
	// 	return application.sources(DemoapplicationApplication.class);
	// } 

	public static void main(String[] args) {
		SpringApplication.run(DemoapplicationApplication.class, args);
	}

}	

