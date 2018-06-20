package com.brasajava.rabbitstreamreactiveone.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.rabbitstreamreactiveone.domain.Contact;
import com.brasajava.rabbitstreamreactiveone.service.ContactService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class ContactController {
	
	@Autowired
	public ContactService service;
	
	@PostMapping("/contact")
	public Mono<Contact> save(@RequestBody Contact contact) {
		if(contact.getId() == null || contact.getId().isEmpty()) {
			contact.setId(String.valueOf(Math.random() * 244574872));
		}
		return service.save(contact);
	}
	
	@GetMapping("/contact/{id}")
	public Mono<Contact> findById(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@GetMapping(value = "/contact", params = "createDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByCreateDate(@RequestParam(value="createDate", required = true) LocalDate date){
		return service.findByCreateDate(date).delayElements(Duration.ofSeconds(3));
	}
	
	@GetMapping(value = "/contact", params = "updateDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByUpdateDate(@RequestParam(value="updateDate", required = true) LocalDate date){
		return service.findByUpdateDate(date).delayElements(Duration.ofSeconds(3));
	}
	
	@GetMapping(value = "/contact", params = "createTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByCreateDate(@RequestParam(value="createTime", required = true) LocalTime time){
		return service.findByCreateTime(time).delayElements(Duration.ofSeconds(3));
	}
	
	@GetMapping(value = "/contact", params = "updateTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByUpdateDate(@RequestParam(value="updateTime", required = true) LocalTime time){
		return service.findByUpdateTime(time).delayElements(Duration.ofSeconds(3));
	}
	
	@GetMapping(value = "/contact", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findAll(){
		return service.findAll().delayElements(Duration.ofSeconds(3));
	}
	
	@GetMapping(value = "/contact", params = "count")
	public Mono<Long> count(){
		return service.count();
	}
	
	@DeleteMapping("/contact/{id}")
	public Mono<Boolean> deleteById(@PathVariable("id") String id){
		return service.deleteById(id);
	}

}
