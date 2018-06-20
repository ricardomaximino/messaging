package com.verisure.vcp.newmicroservice.service;


import java.time.LocalDate;
import java.time.LocalTime;

import com.verisure.vcp.newmicroservice.api.dto.ProfileDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Profile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Sample service interface used as template. <b>Please remove for actual project implementation.</b>
 *
 * @author FaaS [faas@securitasdirect.es]
 * @since 1.0.0
 */
public interface ProfileService {

	/**
	 * Save or update an profile on the database.
	 *
	 * @param profile the profile
	 * @return the mono
	 */
    public Mono<Profile> save(ProfileDTO profile);
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the mono
     */
    public Mono<Profile> findById(String id);
    
    /**
     * Delete by id.
     *
     * @param id the id
     * @param operator the operator
     * @return the mono
     */
    public Mono<Boolean> deleteById(String id, String operator);
    
    /**
     * Count.
     *
     * @return the mono
     */
    public Mono<Long> count();

	/**
	 * Gets all the profiles.
	 * 
	 * @return The  Flux of profile.
	 */
    public Flux<Profile> findAll();
    
    
    /**
     * Find by birthday.
     *
     * @param date the date to search on the database.
     * @return the flux of profile.
     */
    public Flux<Profile> findByBirthday(LocalDate date);
    
    /**
     * Find by create date.
     *
     * @param date the date
     * @return the flux
     */
    public Flux<Profile> findByCreateDate(LocalDate date);
    
    /**
     * Find by create time.
     *
     * @param time the time
     * @return the flux
     */
    public Flux<Profile> findByCreateTime(LocalTime time);
    
    /**
     * Find by update date.
     *
     * @param date the date
     * @return the flux
     */
    public Flux<Profile> findByUpdateDate(LocalDate date);
    
    /**
     * Find by update time.
     *
     * @param time the time
     * @return the flux
     */
    public Flux<Profile> findByUpdateTime(LocalTime time);

}
