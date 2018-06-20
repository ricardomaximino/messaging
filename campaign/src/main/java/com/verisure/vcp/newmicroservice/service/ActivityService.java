package com.verisure.vcp.newmicroservice.service;

import java.time.LocalDate;
import java.time.LocalTime;

import com.verisure.vcp.newmicroservice.api.dto.ActivityDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Activity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Interface ActivityService.
 */
public interface ActivityService {
	
	/**
	 * Save.
	 *
	 * @param activityDTO the activity DTO
	 * @return the mono
	 */
	public Mono<Activity> save(ActivityDTO activityDTO);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Activity> findById(String id);
	
	/**
	 * Delete by id.
	 *
	 * @param operatorId the operator id
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Boolean> deleteById(String operatorId, String id);
	
	/**
	 * Find all.
	 *
	 * @return the flux
	 */
	public Flux<Activity> findAll();
	
	/**
	 * Find by start date.
	 *
	 * @param date the date
	 * @return the flux
	 */
	public Flux<Activity> findByStartDate(LocalDate date);
	
	/**
	 * Find by start time.
	 *
	 * @param time the time
	 * @return the flux
	 */
	public Flux<Activity> findByStartTime(LocalTime time);
	
	/**
	 * Find by end date.
	 *
	 * @param date the date
	 * @return the flux
	 */
	public Flux<Activity> findByEndDate(LocalDate date);
	
	/**
	 * Find by end time.
	 *
	 * @param time the time
	 * @return the flux
	 */
	public Flux<Activity> findByEndTime(LocalTime time);
	
	/**
	 * Find by operator id.
	 *
	 * @param operatorId the operator id
	 * @return the flux
	 */
	public Flux<Activity> findByOperatorId(String operatorId);
	
	/**
	 * Find by result id.
	 *
	 * @param resultId the result id
	 * @return the flux
	 */
	public Flux<Activity> findByResultId(String resultId);

}
