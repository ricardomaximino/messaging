package com.verisure.vcp.newmicroservice.service;


import java.util.List;

import org.springframework.expression.spel.ast.Operator;

import com.verisure.vcp.newmicroservice.api.dto.CampaignDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Campaign;
import com.verisure.vcp.newmicroservice.domain.entity.Contact;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * Sample service interface used as template. <b>Please remove for actual project implementation.</b>
 *
 * @author FaaS [faas@securitasdirect.es]
 * @since 1.0.0
 */
public interface CampaignService {

	
    /**
     * Creates the.
     *
     * @param operatorId the operator id
     * @param name the name
     * @return the mono
     */
    public Mono<Campaign> create(String operatorId, String name);
    
    /**
     * Creates the.
     *
     * @param operatorId the operator id
     * @param name the name
     * @param description the description
     * @return the mono
     */
    public Mono<Campaign> create(String operatorId, String name, String description);
    
    /**
     * Adds the operator.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param operator the operator
     * @return the mono
     */
    public Mono<Campaign> addOperator(String operatorId, String campaignId, Operator operator);
    
    /**
     * Adds the contact.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param contact the contact
     * @return the mono
     */
    public Mono<Campaign> addContact(String operatorId, String campaignId, Contact contact);
    
    /**
     * Adds the operators.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param operatorList the operator list
     * @return the mono
     */
    public Mono<Campaign> addOperators(String operatorId, String campaignId, List<Operator> operatorList);
    
    /**
     * Adds the contacts.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param contactList the contact list
     * @return the mono
     */
    public Mono<Campaign> addContacts(String operatorId, String campaignId, List<Contact> contactList);
    
    /**
     * Removes the operator.
     *
     * @param transactionOperatorId the transaction operator id
     * @param campaignId the campaign id
     * @param operatorId the operator id
     * @return the mono
     */
    public Mono<Campaign> removeOperator(String transactionOperatorId,String campaignId, String operatorId);
    
    /**
     * Removes the contact.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param contactId the contact id
     * @return the mono
     */
    public Mono<Campaign> removeContact(String operatorId, String campaignId, String contactId);
    
    /**
     * Sets the operators.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param operatorList the operator list
     * @return the mono
     */
    public Mono<Campaign> setOperators(String operatorId, String campaignId, List<Operator> operatorList);
    
    /**
     * Sets the contacts.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param contactList the contact list
     * @return the mono
     */
    public Mono<Campaign> setContacts(String operatorId, String campaignId, List<Contact> contactList);
    
    /**
     * Count contacts.
     *
     * @return the mono
     */
    public Mono<Long> countContacts();
    
    /**
     * Count operators.
     *
     * @return the mono
     */
    public Mono<Long> countOperators();
    
    /**
     * Exist operator.
     *
     * @param campaignId the campaign id
     * @param operatorId the operator id
     * @return the mono
     */
    public Mono<Boolean> existOperator(String campaignId, String operatorId);
    
    /**
     * Exist contact.
     *
     * @param campaignId the campaign id
     * @param contactId the contact id
     * @return the mono
     */
    public Mono<Boolean> existContact(String campaignId, String contactId);

    /**
     * Sets the name.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param name the name
     * @return the mono
     */
    public Mono<Campaign> setName(String operatorId, String campaignId, String name);
    
    /**
     * Sets the description.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param description the description
     * @return the mono
     */
    public Mono<Campaign> setDescription(String operatorId, String campaignId, String description);
    
    /**
     * Sets the campaign.
     *
     * @param operatorId the operator id
     * @param campaignId the campaign id
     * @param name the name
     * @param description the description
     * @return the mono
     */
    public Mono<Campaign> setCampaign(String operatorId, String campaignId, String name, String description);
    
    /**
     * Find all.
     *
     * @return the flux
     */
    public Flux<Campaign> findAll();
    
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
    public Mono<Campaign> findById(String id);

    
    /**
     * Update.
     *
     * @param campaignDTO the campaign DTO
     * @return the mono
     */
    public Mono<Campaign> update(CampaignDTO campaignDTO);
    
    /**
     * Save.
     *
     * @param campaignDTO the campaign DTO
     * @return the mono
     */
    public Mono<Campaign> save(CampaignDTO campaignDTO);
}
