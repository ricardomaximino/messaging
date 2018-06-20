package com.brasajava.rabbitstreamreactiveone;

import java.util.logging.Logger;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;



@SpringBootApplication
public class RabbitStreamReactiveOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitStreamReactiveOneApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(ApplicationContext ctx) {
		return arg -> {

		};
	}
	
	@Bean
	@Scope("prototype")
	public Logger logger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getDeclaredType().getName());
	}
}
