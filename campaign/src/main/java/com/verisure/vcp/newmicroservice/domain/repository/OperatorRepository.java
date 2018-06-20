package com.verisure.vcp.newmicroservice.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verisure.vcp.newmicroservice.domain.entity.Operator;

public interface OperatorRepository extends ReactiveMongoRepository<Operator, String>{
	

}
