package com.verisure.vcp.newmicroservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import com.verisure.vcp.newmicroservice.api.dto.CampaignDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Campaign;
import com.verisure.vcp.newmicroservice.domain.entity.Contact;
import com.verisure.vcp.newmicroservice.domain.repository.CampaignRepository;
import com.verisure.vcp.newmicroservice.service.CampaignService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Sample service implementation.
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Service
@Slf4j
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository applicationRepository;

	@Override
	public Mono<Campaign> create(String operatorId, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> create(String operatorId, String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> addOperator(String operatorId, String campaignId, Operator operator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> addContact(String operatorId, String campaignId, Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> addOperators(String operatorId, String campaignId, List<Operator> operatorList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> addContacts(String operatorId, String campaignId, List<Contact> contactList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> removeOperator(String transactionOperatorId, String campaignId, String operatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> removeContact(String operatorId, String campaignId, String contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> setOperators(String operatorId, String campaignId, List<Operator> operatorList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> setContacts(String operatorId, String campaignId, List<Contact> contactList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Long> countContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Long> countOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existOperator(String campaignId, String operatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existContact(String campaignId, String contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> setName(String operatorId, String campaignId, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> setDescription(String operatorId, String campaignId, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> setCampaign(String operatorId, String campaignId, String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Campaign> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> deleteById(String operatorId, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> update(CampaignDTO campaignDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Campaign> save(CampaignDTO campaignDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
