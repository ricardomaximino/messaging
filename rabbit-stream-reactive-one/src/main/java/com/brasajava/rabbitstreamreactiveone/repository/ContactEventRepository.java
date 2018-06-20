package com.brasajava.rabbitstreamreactiveone.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.brasajava.rabbitstreamreactiveone.domain.ContactEvent;

import reactor.core.publisher.Flux;

public interface ContactEventRepository  extends ReactiveMongoRepository<ContactEvent, String>{
	
	Flux<ContactEvent> findByType(String type);
	Flux<ContactEvent> findBySendDate(LocalDate date);
	Flux<ContactEvent> findByReceiveDate(LocalDate date);
	Flux<ContactEvent> findBySendTime(LocalTime time);
	Flux<ContactEvent> findByReceiveTime(LocalTime time);

}
