package com.brasajava.rabbitstreamone.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.brasajava.rabbitstreamone.domain.Contact;

public interface ContactRepository extends ReactiveMongoRepository<Contact, String>{

}
