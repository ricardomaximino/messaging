package com.brasajava.springbootreactivewebsockettwo.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.springbootreactivewebsockettwo.domain.Contact;
import com.brasajava.springbootreactivewebsockettwo.service.ContactService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ContactController {

	@Autowired
	private ContactService service;
	
	@PostMapping("/contact")
	public Mono<Contact> save(@RequestBody Contact contact){
		return service.save(contact);
	}
	
	@DeleteMapping("/contact/{id}")
	public Mono<Boolean> deleteById(@PathVariable("id") String id){
		return service.deleteById(id);
	}
	
	@GetMapping(value = "/contact", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/contact", params = "createDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByCreateDate(@RequestParam( value = "createDate", required = true) @DateTimeFormat(iso = ISO.DATE)LocalDate date){
		return service.findByCreateDate(date);
	}
	
	@GetMapping(value = "/contact", params = "createTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByCreateTime(@RequestParam( value = "createTime", required = true) @DateTimeFormat(iso = ISO.TIME)LocalTime time){
		return service.findByCreateTime(time);
	}
	
	@GetMapping(value = "/contact", params = "updateDate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByUpdateDate(@RequestParam( value = "updateDate", required = true) @DateTimeFormat(iso = ISO.DATE)LocalDate date){
		return service.findByUpdateDate(date);
	}
	
	@GetMapping(value = "/contact", params = "updateTime", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Contact> findByUpdateTime(@RequestParam( value = "updateTime", required = true) @DateTimeFormat(iso = ISO.TIME)LocalTime time){
		return service.findByUpdateTime(time);
	}
}
