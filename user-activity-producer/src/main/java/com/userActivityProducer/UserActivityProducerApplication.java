package com.userActivityProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class UserActivityProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserActivityProducerApplication.class, args);
	}

}
