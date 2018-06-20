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

import com.verisure.vcp.newmicroservice.api.dto.ResultDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Result;
import com.verisure.vcp.newmicroservice.service.ResultService;

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
@RequestMapping("/result")
@Api(value = "Result - Campaign API")
public class ResultController {

	@Autowired
    private ResultService resultService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Results", response = Result.class)
    public Flux<Result> findAll() {
        LOGGER.debug("Search ALL Skills");
        return resultService.findAll();

    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search Result by id", response = Result.class)
    public Mono<Result> findById(@PathVariable("id") String id) {
        LOGGER.debug("Searching Result by id: " + id);
        return resultService.findById(id);

    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an Result")
    public Mono<Result> create(@Valid @RequestBody ResultDTO resultDTO) {
        LOGGER.debug("Creating an Result: {}", resultDTO.toString());
        return resultService.save(resultDTO);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an Result")
    public Mono<Result> update(@Valid @RequestBody ResultDTO resultDTO) {
        LOGGER.debug("Updating an Result: {}", resultDTO.toString());
        return resultService.save(resultDTO);
    }

    @DeleteMapping(value = "/{id}", params = "operator")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleted an Result")
    public Mono<Boolean> delete(@RequestParam(value = "operator", required = true) String operator, @PathVariable("id") String id) {
        LOGGER.debug("Deleting an Result: " + id);
        return resultService.deleteById(operator, id);
    }
}
