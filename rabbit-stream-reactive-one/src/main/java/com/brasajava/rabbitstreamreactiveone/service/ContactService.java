package com.brasajava.rabbitstreamreactiveone.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasajava.rabbitstreamreactiveone.domain.Contact;
import com.brasajava.rabbitstreamreactiveone.domain.ContactEvent;
import com.brasajava.rabbitstreamreactiveone.repository.ContactRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private ContactSenderService sender;


	public Mono<Contact> save(Contact contact) {
		return repository.existsById(contact.getId()).flatMap(exist -> {
				if(exist) {
					update(contact);
					return repository.save(contact);
				}else {
					create(contact);
					return repository.save(contact);
				}
		});
	}

	
	public Mono<Boolean> deleteById(String id){
		return repository.existsById(id).flatMap(exist -> {
			if(exist) {
				repository.findById(id).subscribe(c -> 	delete(c));
				return repository.deleteById(id).map(d -> true);
			}
			return Mono.just(new Boolean(false));
		});
	}
	
	
	public Mono<Contact> findById(String id){
		return repository.findById(id);
	}
	
	public Flux<Contact> findByCreateDate(LocalDate date){
		return repository.findByCreateDate(date);
	}
	
	public Flux<Contact> findByUpdateDate(LocalDate date){
		return repository.findByUpdateDate(date);
	}
	
	public Flux<Contact> findByCreateTime(LocalTime time){
		return repository.findByCreateTime(time);
	}
	
	public Flux<Contact> findByUpdateTime(LocalTime time){
		return repository.findByUpdateTime(time);
	}
	
	public Flux<Contact> findAll(){
		return repository.findAll();
	}

	public Mono<Long> count(){
		return repository.count();
	}
	
	
	
	
	private Contact create(Contact contact) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		contact.setCreateDate(date);
		contact.setUpdateDate(date);
		contact.setCreateTime(time);
		contact.setUpdateTime(time);
		sender.sendContactCreatedEvent(new ContactEvent("01","Created", contact.getId(), contact, date, date, time, time));
		return contact;
	}
	
	private Contact update(Contact contact) {
		repository.findById(contact.getId()).subscribe(c -> {contact.setCreateDate(c.getCreateDate());contact.setCreateTime(c.getCreateTime());});
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		contact.setUpdateDate(date);
		contact.setUpdateTime(time);
		sender.sendContactUpdatedEvent(new ContactEvent("02","Updated", contact.getId(), contact, date, date, time, time));
		return contact;
	}

	private void delete(Contact contact) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		sender.sendContactDeleteEvent(new ContactEvent("03", "Deleted", contact.getId(), contact, date, date, time, time));
	}
}
