package com.brasajava.rabbitstreamsenderone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.brasajava.rabbitstreamsenderone.domain.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{}