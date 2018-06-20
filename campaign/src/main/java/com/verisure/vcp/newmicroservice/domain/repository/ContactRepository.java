package com.verisure.vcp.newmicroservice.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verisure.vcp.newmicroservice.domain.entity.Contact;

import reactor.core.publisher.Flux;

public interface ContactRepository extends ReactiveMongoRepository<Contact, String>{
	
	Flux<Contact> findByProfileId(String profileId);

}
