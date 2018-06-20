package com.brasajava.springbootreactivewebsockettwo.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.springbootreactivewebsockettwo.domain.Event;
import com.brasajava.springbootreactivewebsockettwo.repository.EventRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EventController {
	
	@Autowired
	private EventRepository repository;
	
	@GetMapping("/event/{id}")
	public Mono<Event> findById(@PathVariable("id") String id){
		return repository.findById(id);
	}
	
	@GetMapping(value = "/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/event", params = "type", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> findByType(@RequestParam(value = "type", required = true) String type){
		return repository.findByType(type);
	}
	
	@GetMapping(value = "/event", params = "createDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> findByCreateDate(@RequestParam( value = "createDate", required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date){
		return repository.findByCreateDate(date);
	}
	
	@GetMapping(value = "/event", params = "createTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> findByCreateTime(@RequestParam( value = "createTime", required = true) @DateTimeFormat(iso = ISO.TIME)LocalTime time){
		return repository.findByCreateTime(time);
	}
}
