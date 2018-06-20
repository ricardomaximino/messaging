package com.brasajava.rabbitstreamreactiveone.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.rabbitstreamreactiveone.domain.PersonEvent;
import com.brasajava.rabbitstreamreactiveone.repository.PersonEventRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class PersonEventController {

	
	@Autowired
	private PersonEventRepository repository;
	
	@GetMapping(value = "/person-event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PersonEvent> findAll(){
		return repository.findAll();
	}
	@GetMapping(value = "/person-event/{id}")
	public Mono<PersonEvent> findById(String id){
		return repository.findById(id);
	}
	
	@GetMapping(value = "/person-event", params = "sendDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PersonEvent> findBySendDate(LocalDate date){
		return repository.findBySendDate(date);		
	}
	
	@GetMapping(value = "/person-event", params = "receiveDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PersonEvent> findByReceiveDate(LocalDate date){
		return repository.findByReceiveDate(date);
	}
	
	@GetMapping(value = "/person-event", params = "sendTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PersonEvent> findBySendTime(LocalTime time){
		return repository.findBySendTime(time);		
	}
	
	@GetMapping(value = "/person-event", params = "receiveTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PersonEvent> findByReceiveTime(LocalTime time){
		return repository.findByReceiveTime(time);
	}
	
	@GetMapping(value = "/person-event", params = "type", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PersonEvent> findByType(String type){
		return repository.findByType(type);
	}
	
	@GetMapping(value = "/person-event", params = "count")
	public Mono<Long> count(){
		return repository.count();
	}
}
