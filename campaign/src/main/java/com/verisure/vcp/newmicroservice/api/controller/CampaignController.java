package com.verisure.vcp.newmicroservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.verisure.vcp.newmicroservice.domain.entity.Campaign;
import com.verisure.vcp.newmicroservice.domain.entity.Contact;
import com.verisure.vcp.newmicroservice.service.CampaignService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Sample controller used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Slf4j
@RestController
@RequestMapping("/application")
@Api(value = "Contact - Campaign API")
public class CampaignController {

	@Autowired
    private CampaignService campaignService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Campaigns", response = Campaign.class)
    public Flux<Campaign> findAll() {
        LOGGER.debug("Search ALL Campaign");
        return campaignService.findAll();

    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search Campaign by id", response = Campaign.class)
    public Mono<Campaign> findById(@PathVariable("id") String id) {
        LOGGER.debug("Searching Campaign by id: " + id);
        return campaignService.findById(id);

    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an Campaign")
    public Mono<Campaign> create(@Valid @RequestBody Campaign campaign) {
        LOGGER.debug("Creating an Campaign: {}", campaign.toString());
        return campaignService.save(campaign);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an Campaign")
    public Mono<Campaign> update(@Valid @RequestBody Campaign campaign) {
        LOGGER.debug("Updating an Campaign: {}", campaign.toString());
        return campaignService.update(campaign);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleted an Campaign")
    public Mono<Boolean> delete(@PathVariable("id") String id) {
        LOGGER.debug("Deleting an Campaign: " + id);
        return campaignService.deleteById(id);
    }
    
    @PostMapping(value = "/{id}/operator",consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Add a operator to a campaign list")
    public Mono<Campaign> addOperator(@PathVariable("id") String id, @Valid @RequestBody Operator operator) {
        LOGGER.debug("Add a operator to a campaign list: {}", operator.toString());
        return campaignService.addOperator (id, operator);
    }
    
    @DeleteMapping(value = "/{id}/operator/{operatorId}",consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Remove a operator to a campaign list")
    public Mono<Campaign> addOperator(@PathVariable("id") String id, @PathVariable("operatorId") String operatorId) {
        LOGGER.debug("Remove a operator to a campaign list");
        return campaignService.removeOperator(id, operatorId); 
    }
    
    @PostMapping(value = "/{id}/contact",consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Add a contact to a campaign list")
    public Mono<Campaign> addContact(@PathVariable("id") String id, @Valid @RequestBody Contact contact) {
        LOGGER.debug("Add a contact to a campaign list: {}", contact.toString());
        return campaignService.addContact(id, contact);
    }
    
    @DeleteMapping(value = "/{id}/contact/{contactId}",consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Remove a contact to a campaign list")
    public Mono<Campaign> removeContact(@PathVariable("id") String id, @PathVariable("contactId") String contactId) {
        LOGGER.debug("Remove a contact to a campaign list");
        return campaignService.removeContact(id, contactId); 
    }
    
}
