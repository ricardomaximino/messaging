package com.brasajava.rabbitstreamone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;



@SpringBootApplication
@EnableReactiveMongoRepositories
public class RabbitStreamOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitStreamOneApplication.class, args);
	}	

}
