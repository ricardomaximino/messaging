package com.verisure.vcp.newmicroservice.service;

import java.util.List;

import com.verisure.vcp.newmicroservice.api.dto.ContactDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Activity;
import com.verisure.vcp.newmicroservice.domain.entity.Contact;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * The Interface ContactService.
 */
public interface ContactService {
	
	/**
	 * Save.
	 *
	 * @param contact the contact
	 * @return the mono
	 */
	public Mono<Contact> save(ContactDTO contactDTO);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Contact> findById(String id);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	public Mono<Boolean> deleteById(String operatorId, String id);
	
	/**
	 * Find all.
	 *
	 * @return the flux
	 */
	public Flux<Contact> findAll();
	
	/**
	 * Find by profile id.
	 *
	 * @param profileId the profile id
	 * @return the flux
	 */
	public Flux<Contact> findByProfileId(String profileId);
	
	/**
	 * Find by result id.
	 *
	 * @param ResultId the result id
	 * @return the flux
	 */
	public Flux<Contact> findByResultId(String resultId);
	
	/**
	 * Find by origin.
	 *
	 * @param origin the origin
	 * @return the flux
	 */
	public Flux<Contact> findByOrigin(String origin);
	
	/**
	 * Adds the activity.
	 *
	 * @param contactId the contact id
	 * @param activity the activity
	 * @return the mono
	 */
	public Mono<Contact> addActivity(String operatorId, String contactId, Activity activity);
	
	/**
	 * Adds the activities.
	 *
	 * @param contactId the contact id
	 * @param activityList the activity list
	 * @return the mono
	 */
	public Mono<Contact> addActivities(String operatorId, String contactId, List<Activity> activityList);
	
	/**
	 * Sets the activities.
	 *
	 * @param contactId the contact id
	 * @param activityList the activity list
	 * @return the mono
	 */
	public Mono<Contact> setActivities(String operatorId, String contactId, List<Activity> activityList);
	
	/**
	 * Belong this activity to this contact.
	 *
	 * @param contactId the contact id
	 * @param activityId the activity id
	 * @return the mono
	 */
	public Mono<Boolean> existActivity(String contactId, String activityId); 
	
	
	/**
	 * Removes the activity.
	 *
	 * @param operatorId the operator id
	 * @param contactId the contact id
	 * @param activityId the activity id
	 * @return the mono
	 */
	public Mono<Contact> removeActivity(String operatorId, String contactId, String activityId);

}
