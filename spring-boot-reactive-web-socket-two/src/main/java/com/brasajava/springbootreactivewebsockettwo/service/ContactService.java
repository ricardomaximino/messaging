package com.brasajava.springbootreactivewebsockettwo.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasajava.springbootreactivewebsockettwo.domain.Contact;
import com.brasajava.springbootreactivewebsockettwo.repository.ContactRepository;
import com.brasajava.springbootreactivewebsockettwo.utils.EventBuilder;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactService {
	@Autowired
	private ContactSenderService sender;
	
	@Autowired
	private ContactRepository repository;
	
	
	public Mono<Contact> save(Contact contact){
		if(contact.getId() != null && !contact.getId().isEmpty()) {
			return repository.existsById(contact.getId()).flatMap(exist -> {
				if(exist) {
					setContactUpdateMoment(contact);
					sender.sendUpdatedEvent(EventBuilder.contactUpdatedEvent(contact));
					return repository.save(contact);
				}else {
					setContactCreateMoment(contact);
					sender.sendCreatedEvent(EventBuilder.contactCreatedEvent(contact));
					return repository.save(contact);
				}
			});
		}else {
			return repository.save(contact).map(p -> {
				setContactCreateMoment(contact);
				sender.sendCreatedEvent(EventBuilder.contactCreatedEvent(contact));
				return p;
			});
		}
	}
	
	public Mono<Boolean> deleteById(String id){
		return repository.existsById(id).flatMap(exist -> {
			if(exist) {
				repository.findById(id).subscribe(c -> 	sender.sendDeletedEvent(EventBuilder.contactDeletedEvent(c)));
				return repository.deleteById(id).map(d -> true);
			}
			return Mono.just(new Boolean(false));
		});
	}
	
	public Mono<Long> count(){
		return repository.count();
	}
	
	public Flux<Contact> findAll() {
		return repository.findAll();
	}
	
	public Flux<Contact> findByCreateDate(LocalDate date){
		return repository.findByCreateDate(date);
	}
	
	public Flux<Contact> findByCreateTime(LocalTime time){
		return repository.findByCreateTime(time);
	}
	
	public Flux<Contact> findByUpdateDate(LocalDate date){
		return repository.findByUpdateDate(date);
	}
	
	public Flux<Contact> findByUpdateTime(LocalTime time){
		return repository.findByUpdateTime(time);
	}
	
	private void setContactUpdateMoment(Contact contact) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		contact.setUpdateDate(date);
		contact.setUpdateTime(time);
	}
	
	private void setContactCreateMoment(Contact contact) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		contact.setCreateDate(date);
		contact.setCreateTime(time);
		contact.setUpdateDate(date);
		contact.setUpdateTime(time);
	}
}
