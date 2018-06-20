package com.verisure.vcp.newmicroservice.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verisure.vcp.newmicroservice.domain.entity.Activity;

public interface ActivityRepository extends ReactiveMongoRepository<Activity, String>{

}
