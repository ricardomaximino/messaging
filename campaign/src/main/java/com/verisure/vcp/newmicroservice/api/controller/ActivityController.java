package com.verisure.vcp.newmicroservice.api.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.verisure.vcp.newmicroservice.domain.entity.Activity;
import com.verisure.vcp.newmicroservice.service.ActivityService;

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
@RequestMapping("/activity")
@Api(value = "Activity - Campaign API")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities", response = Activity.class)
    public Flux<Activity> findAll() {
        LOGGER.debug("Search ALL Activities");
        return activityService.findAll();

    }
    
    @GetMapping(params = "operatorId", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities for an specific operator", response = Activity.class)
    public Flux<Activity> findByOperatorId(@RequestParam(value ="operatorId", required = true) String operatorId) {
        LOGGER.debug("Search ALL Activities for an specific operator");
        return activityService.findByOperatorId(operatorId);

    }
    
    @GetMapping(params = "resultId", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities for an specific result", response = Activity.class)
    public Flux<Activity> findByResultId(@RequestParam(value ="resultId", required = true) String resultId) {
        LOGGER.debug("Search ALL Activities for an specific result");
        return activityService.findByResultId(resultId);

    }
    
    @GetMapping(params = "startDate", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities for an specific start date", response = Activity.class)
    public Flux<Activity> findByStartDate(@RequestParam(value ="startDate", required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
        LOGGER.debug("Search ALL Activities for an specific start date");
        return activityService.findByStartDate(date);

    }
    
    @GetMapping(params = "startTime", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities for an specific start time", response = Activity.class)
    public Flux<Activity> findByStartTime(@RequestParam(value ="start time", required = true) @DateTimeFormat(iso = ISO.TIME) LocalTime time) {
        LOGGER.debug("Search ALL Activities for an specific start time");
        return activityService.findByStartTime(time);

    }
    
    
    @GetMapping(params = "endDate", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities for an specific end date", response = Activity.class)
    public Flux<Activity> findByEndDate(@RequestParam(value ="endDate", required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
        LOGGER.debug("Search ALL Activities for an specific end date");
        return activityService.findByEndDate(date);

    }
    
    @GetMapping(params = "endTime", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search ALL Activities for an specific end time", response = Activity.class)
    public Flux<Activity> findByEndTime(@RequestParam(value ="endTime", required = true) @DateTimeFormat(iso = ISO.TIME) LocalTime time) {
        LOGGER.debug("Search ALL Activities for an specific end time");
        return activityService.findByEndTime(time);

    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Search Activity by id", response = Activity.class)
    public Mono<Activity> findById(@PathVariable("id") String id) {
        LOGGER.debug("Searching Activity by id: " + id);
        return activityService.findById(id);

    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an Activity")
    public Mono<Activity> create(@Valid @RequestBody Activity activity) {
        LOGGER.debug("Creating an activity: {}", activity.toString());
        return activityService.save(activity);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an Activity")
    public Mono<Activity> update(@Valid @RequestBody Activity activity) {
        LOGGER.debug("Updating an activity: {}", activity.toString());
        return activityService.save(activity);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleted an Activity")
    public Mono<Boolean> delete(@PathVariable("id") String id) {
        LOGGER.debug("Deleting an activity: " + id);
        return activityService.deleteById(id);
    }

}
