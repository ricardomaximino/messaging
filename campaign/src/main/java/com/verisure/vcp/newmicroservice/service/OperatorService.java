package com.verisure.vcp.newmicroservice.service;


import com.verisure.vcp.newmicroservice.api.dto.OperatorDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Operator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Interface OperatorService.
 */
public interface OperatorService {
	
	/**
	 * Save.
	 *
	 * @param operatorDTO the operator DTO
	 * @return the mono
	 */
	public Mono<Operator> save(OperatorDTO operatorDTO);
	
	/**
	 * Delete by id.
	 *
	 * @param operatorId the operator id
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Boolean> deleteById(String operatorId, String id);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Operator> findById(String id);
	
	/**
	 * Find by skills.
	 *
	 * @param skillsId the skills id
	 * @return the flux
	 */
	public Flux<Operator> findBySkills(String skillsId);
	
	/**
	 * Find all.
	 *
	 * @return the flux
	 */
	public Flux<Operator> findAll();
	
}
