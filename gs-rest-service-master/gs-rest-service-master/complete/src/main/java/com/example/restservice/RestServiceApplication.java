package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties

public class RestServiceApplication {

	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.out.println("RestServiceApplication.setProjectName()"+projectName);
	}
	
	@Autowired
	void setEnvironment(Environment env) {
		
		System.out.println("RestServiceApplication.setEnvironment(ENV)"+env.getProperty("configuration.projectName"));
		
	}
	
	
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
