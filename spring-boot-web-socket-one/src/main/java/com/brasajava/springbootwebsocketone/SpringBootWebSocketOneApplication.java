package com.brasajava.springbootwebsocketone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebSocketOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebSocketOneApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(ApplicationContext ctx) {
		return args -> {
			for(String name : ctx.getBeanDefinitionNames()) {
				System.out.println(name);			
			}
		};
	}
}
