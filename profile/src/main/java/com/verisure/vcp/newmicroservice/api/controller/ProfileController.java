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

import com.verisure.vcp.newmicroservice.api.converter.ProfileConverter;
import com.verisure.vcp.newmicroservice.api.dto.ProfileDTO;
import com.verisure.vcp.newmicroservice.service.ProfileService;

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
@RequestMapping("/profile")
@Api(value = "Profile API")
public class ProfileController {

    @Autowired
    private ProfileConverter profileConverter;

    @Autowired
    private ProfileService profileService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "View the list of ALL profiles", response = ProfileDTO.class)
    public Flux<ProfileDTO> findAll() {
        LOGGER.debug("Trying to retrieve all profiles");
        return profileService.findAll().map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(produces = "application/json", params = "birthday")
    @ResponseBody
    @ApiOperation(value = "View the list of ALL profiles that has the birthday equal the param", response = ProfileDTO.class)
    public Flux<ProfileDTO> findByBirthday(@RequestParam(value = "birthday", required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
        LOGGER.debug("Trying to retrieve all profiles that has the birthday equal to " + date);
        return profileService.findByBirthday(date).map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(produces = "application/json", params = "createDate")
    @ResponseBody
    @ApiOperation(value = "View the list of ALL profiles that has the create date equal the param", response = ProfileDTO.class)
    public Flux<ProfileDTO> findByCreateDate(@RequestParam(value = "createDate", required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
        LOGGER.debug("Trying to retrieve all profiles that has the create date equal to " + date);
        return profileService.findByCreateDate(date).map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(produces = "application/json", params = "createTime")
    @ResponseBody
    @ApiOperation(value = "View the list of ALL profiles that has the create time equal the param", response = ProfileDTO.class)
    public Flux<ProfileDTO> findByCreateTime(@RequestParam(value = "createTime", required = true) @DateTimeFormat(iso = ISO.TIME) LocalTime time) {
        LOGGER.debug("Trying to retrieve all profiles that has the create time equal to " + time);
        return profileService.findByCreateTime(time).map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(produces = "application/json", params = "updateDate")
    @ResponseBody
    @ApiOperation(value = "View the list of ALL profiles that has the update date equal the param", response = ProfileDTO.class)
    public Flux<ProfileDTO> findByUpdateDate(@RequestParam(value = "updateDate", required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
        LOGGER.debug("Trying to retrieve all profiles that has the update date equal to " + date);
        return profileService.findByUpdateDate(date).map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(produces = "application/json", params = "updateTime")
    @ResponseBody
    @ApiOperation(value = "View the list of ALL profiles that has the update time equal the param", response = ProfileDTO.class)
    public Flux<ProfileDTO> findByUpdateTime(@RequestParam(value = "updateTime", required = true) @DateTimeFormat(iso = ISO.TIME) LocalTime time) {
        LOGGER.debug("Trying to retrieve all profiles that has the update time equal to " + time);
        return profileService.findByUpdateTime(time).map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Find a profile by id", response = ProfileDTO.class)
    public Mono<ProfileDTO> findById(@PathVariable("id") String id) {
        LOGGER.debug("Trying to find the profile with id = " + id);
        return profileService.findById(id).map(profileConverter::toProfileDTO);

    }
    
    @GetMapping(params = "count")
    @ResponseBody
    @ApiOperation(value = "Count all the profiles", response = Long.class)
    public Mono<Long> count() {
        LOGGER.debug("Counting all the profiles");
        return profileService.count();

    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an Profile")
    public Mono<ProfileDTO> create(@Valid @RequestBody ProfileDTO request) {
        LOGGER.debug("Creating an profile: {}", request.toString());
        return profileService.save(request).map(profileConverter::toProfileDTO);
    }
    
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an Profile")
    public Mono<ProfileDTO> update(@Valid @RequestBody ProfileDTO request) {
        LOGGER.debug("Creating an profile: {}", request.toString());
        return profileService.save(request).map(profileConverter::toProfileDTO);
    }
    
    @DeleteMapping(value = "/{id}", params = "operator")
    @ResponseBody
    @ApiOperation(value = "Delete the profile with the id equals the params if it exist", response = ProfileDTO.class)
    public Mono<Boolean> deleteById(@PathVariable("id") String id, @RequestParam(value = "operator", required = true) String operator) {
        LOGGER.debug("Trying to delete the profile with the id = " + id);
        return profileService.deleteById(id, operator);

    }


}
