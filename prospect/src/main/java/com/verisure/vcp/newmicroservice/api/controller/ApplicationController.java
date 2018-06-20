package com.verisure.vcp.newmicroservice.api.controller;

import com.verisure.vcp.newmicroservice.api.converter.ItemConverter;
import com.verisure.vcp.newmicroservice.api.dto.ItemDTO;
import com.verisure.vcp.newmicroservice.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sample controller used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Slf4j
@RestController
@RequestMapping("/application")
@Api(value = "Application demo")
public class ApplicationController {

    @Autowired
    private ItemConverter itemConverter;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "view the list of ALL application items", response = ItemDTO.class)
    public List<ItemDTO> getItems() {
        LOGGER.debug("Trying to retrieve all items");
        return applicationService.getApplicationItems().stream()
                .map(itemConverter::toItemDto)
                .collect(Collectors.toList());

    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an application item")
    public void createAlert(@Valid @RequestBody ItemDTO request) {
        LOGGER.debug("Creating an item: {}", request.toString());
        applicationService.createApplicationItem(itemConverter.toApplicationItem(request));
    }


}
