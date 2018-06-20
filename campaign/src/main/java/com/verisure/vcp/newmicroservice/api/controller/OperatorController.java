package com.verisure.vcp.newmicroservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.verisure.vcp.newmicroservice.api.dto.OperatorDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Operator;
import com.verisure.vcp.newmicroservice.service.OperatorService;

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
@RequestMapping("/operator")
@Api(value = "Operator - Campaign API")
public class OperatorController {

	@Autowired
    private OperatorService operatorService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Operators", response = Operator.class)
    public Flux<Operator> findAll() {
        LOGGER.debug("Search ALL Operators");
        return operatorService.findAll();

    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search Operator by id", response = Operator.class)
    public Mono<Operator> findById(@PathVariable("id") String id) {
        LOGGER.debug("Searching Operator by id: " + id);
        return operatorService.findById(id);

    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an Skills")
    public Mono<Operator> create(@Valid @RequestBody OperatorDTO operatorDTO) {
        LOGGER.debug("Creating an Skills: {}", operatorDTO.toString());
        return operatorService.save(operatorDTO);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an Operator")
    public Mono<Operator> update(@Valid @RequestBody OperatorDTO operatorDTO) {
        LOGGER.debug("Updating an Skills: {}", operatorDTO.toString());
        return operatorService.save(operatorDTO);
    }

    @DeleteMapping(value = "/{id}", params = "operator")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleted an Operator")
    public Mono<Boolean> delete(@RequestParam(value = "operator", required = true) String operator, @PathVariable("id") String id) {
        LOGGER.debug("Deleting an Operator: " + id);
        return operatorService.deleteById(operator, id);
    }
}
