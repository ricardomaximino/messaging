package com.brasajava.springbootreactivewebsockettwo.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasajava.springbootreactivewebsockettwo.domain.Person;
import com.brasajava.springbootreactivewebsockettwo.repository.PersonRepository;
import com.brasajava.springbootreactivewebsockettwo.utils.EventBuilder;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

	@Autowired
	private PersonSenderService sender;
	
	@Autowired
	private PersonRepository repository;
	
	
	public Mono<Person> save(Person person){
		if(person.getId() != null && !person.getId().isEmpty()) {
			return repository.existsById(person.getId()).flatMap(exist -> {
				if(exist) {
					setPersontUpdateMoment(person);
					sender.sendUpdatedEvent(EventBuilder.personUpdatedEvent(person));
					return repository.save(person);
				}else {
					setPersonCreateMoment(person);
					sender.sendCreatedEvent(EventBuilder.personCreatedEvent(person));
					return repository.save(person);
				}
			});
		}else {
			return repository.save(person).map(p -> {
				setPersonCreateMoment(person);
				sender.sendCreatedEvent(EventBuilder.personCreatedEvent(person));
				return p;
			});
		}
	}
	
	public Mono<Boolean> deleteById(String id){
		return repository.existsById(id).flatMap(exist -> {
			if(exist) {
				repository.findById(id).subscribe(p -> 	sender.sendDeletedEvent(EventBuilder.personDeletedEvent(p)));
				return repository.deleteById(id).map(d -> true);
			}
			return Mono.just(new Boolean(false));
		});
	}
	
	public Mono<Long> count(){
		return repository.count();
	}
	
	public Flux<Person> findAll() {
		return repository.findAll();
	}
	
	public Flux<Person> findByCreateDate(LocalDate date){
		return repository.findByCreateDate(date);
	}
	
	public Flux<Person> findByCreateTime(LocalTime time){
		return repository.findByCreateTime(time);
	}
	
	public Flux<Person> findByUpdateDate(LocalDate date){
		return repository.findByUpdateDate(date);
	}
	
	public Flux<Person> findByUpdateTime(LocalTime time){
		return repository.findByUpdateTime(time);
	}
	
	private void setPersontUpdateMoment(Person person) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		person.setUpdateDate(date);
		person.setUpdateTime(time);
	}
	
	private void setPersonCreateMoment(Person person) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		person.setCreateDate(date);
		person.setCreateTime(time);
		person.setUpdateDate(date);
		person.setUpdateTime(time);
	}
}
