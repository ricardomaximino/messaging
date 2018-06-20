package com.verisure.vcp.newmicroservice.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verisure.vcp.newmicroservice.domain.entity.Result;

public interface ResultRepository extends ReactiveMongoRepository<Result, String>{

}
