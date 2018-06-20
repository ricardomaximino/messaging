package com.verisure.vcp.newmicroservice.domain.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verisure.vcp.newmicroservice.domain.entity.Profile;

import reactor.core.publisher.Flux;

/**
 * Sample repository used for demonstration purposes only.  Ideally Spring Data SHOULD be used for building repositories.
 * <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String>{
	
	Flux<Profile> findByBirthday(LocalDate date);
	
	Flux<Profile> findByCreateDate(LocalDate date);
	Flux<Profile> findByCreateTime(LocalTime time);
	
	Flux<Profile> findByUpdateDate(LocalDate date);
	Flux<Profile> findByUpdateTime(LocalTime time);

    
}
