package com.brasajava.springbootreactivewebsockettwo.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.brasajava.springbootreactivewebsockettwo.domain.Event;

import reactor.core.publisher.Flux;

public interface EventRepository extends ReactiveMongoRepository<Event, String>{
	
	Flux<Event> findByCreateDate(LocalDate date);
	Flux<Event> findByCreateTime(LocalTime time);
	
	Flux<Event> findByType(String type);
	Flux<Event> findByKey(String key);

}
