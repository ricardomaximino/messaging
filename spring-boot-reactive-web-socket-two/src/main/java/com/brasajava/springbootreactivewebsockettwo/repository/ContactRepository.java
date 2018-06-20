package com.brasajava.springbootreactivewebsockettwo.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.brasajava.springbootreactivewebsockettwo.domain.Contact;

import reactor.core.publisher.Flux;

public interface ContactRepository extends ReactiveMongoRepository<Contact, String>{
	
	Flux<Contact> findByCreateDate(LocalDate date);
	Flux<Contact> findByCreateTime(LocalTime time);
	
	Flux<Contact> findByUpdateDate(LocalDate date);
	Flux<Contact> findByUpdateTime(LocalTime time);

}
