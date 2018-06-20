package com.brasajava.reactivestream.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.brasajava.reactivestream.domain.Contact;
public interface ContactRepository extends MongoRepository<Contact, String>{}
