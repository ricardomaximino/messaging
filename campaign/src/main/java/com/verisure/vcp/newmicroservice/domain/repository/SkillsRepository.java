package com.verisure.vcp.newmicroservice.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verisure.vcp.newmicroservice.domain.entity.Skills;

public interface SkillsRepository extends ReactiveMongoRepository<Skills, String>{

}
