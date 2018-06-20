package com.verisure.vcp.newmicroservice.service;

import com.verisure.vcp.newmicroservice.api.dto.ResultDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Result;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Interface ResultService.
 */
public interface ResultService {
	
	/**
	 * Save.
	 *
	 * @param resultDTO the result DTO
	 * @return the mono
	 */
	public Mono<Result> save(ResultDTO resultDTO);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Result> findById(String id);
	
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
	public Flux<Result> findAll();

}
