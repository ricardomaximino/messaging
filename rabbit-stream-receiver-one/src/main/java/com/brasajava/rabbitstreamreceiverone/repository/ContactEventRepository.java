package com.brasajava.rabbitstreamreceiverone.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.brasajava.rabbitstreamreceiverone.domain.ContactEvent;

public interface ContactEventRepository extends MongoRepository<ContactEvent, String>{
	
	List<ContactEvent> findByType(String type);
}
