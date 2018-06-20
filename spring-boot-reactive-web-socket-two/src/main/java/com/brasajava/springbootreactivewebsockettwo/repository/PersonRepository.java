package com.brasajava.springbootreactivewebsockettwo.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.brasajava.springbootreactivewebsockettwo.domain.Person;

import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveMongoRepository<Person, String>{

	Flux<Person> findByCreateDate(LocalDate date);
	Flux<Person> findByCreateTime(LocalTime time);
	
	Flux<Person> findByUpdateDate(LocalDate date);
	Flux<Person> findByUpdateTime(LocalTime time);
}
