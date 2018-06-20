package com.brasajava.rabbitstreamreactiveone.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.brasajava.rabbitstreamreactiveone.domain.PersonEvent;

import reactor.core.publisher.Flux;

public interface PersonEventRepository extends ReactiveMongoRepository<PersonEvent, String>{

	Flux<PersonEvent> findBySendDate(LocalDate date);
	Flux<PersonEvent> findByReceiveDate(LocalDate date);
	Flux<PersonEvent> findBySendTime(LocalTime time);
	Flux<PersonEvent> findByReceiveTime(LocalTime time);
	Flux<PersonEvent> findByType(String type);
	
}
