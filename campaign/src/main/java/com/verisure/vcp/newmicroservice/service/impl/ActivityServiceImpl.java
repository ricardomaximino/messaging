package com.verisure.vcp.newmicroservice.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verisure.vcp.newmicroservice.api.dto.ActivityDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Activity;
import com.verisure.vcp.newmicroservice.domain.repository.ActivityRepository;
import com.verisure.vcp.newmicroservice.service.ActivityService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Mono<Activity> save(ActivityDTO activityDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Activity> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> deleteById(String operatorId, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findByStartDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findByStartTime(LocalTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findByEndDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findByEndTime(LocalTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findByOperatorId(String operatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Activity> findByResultId(String resultId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
