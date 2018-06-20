package com.verisure.vcp.newmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Application bootstrap class.
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@SpringBootApplication
@Slf4j
public class Application {

    protected Application() {
        LOGGER.info("Starting REST microservice");
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }

}
