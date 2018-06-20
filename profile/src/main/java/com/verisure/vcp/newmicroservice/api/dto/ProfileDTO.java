package com.verisure.vcp.newmicroservice.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sample DTO object. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO extends BaseDTO {

    @ApiModelProperty(notes = "Operator id ", required = true)
    private String operator;

    @ApiModelProperty(notes = "Profile id ", required = false)
    private String id;
    
    @ApiModelProperty(notes = "Profile name ", required = true)
    private String name;
    
    @ApiModelProperty(notes = "Profile lastname ", required = true)
    private String lastname;
    
    @ApiModelProperty(notes = "Profile birthday ", required = true)
    private LocalDate birthday;
    
    @ApiModelProperty(notes = "Profile details ", required = false)
    private String details;
    
    @ApiModelProperty(notes = "Profile creation date ", required = true)
    private LocalDate createDate;
    
    @ApiModelProperty(notes = "Profile creation time ", required = true)
    private LocalTime createTime;
    
    @ApiModelProperty(notes = "Profile update date ", required = true)
    private LocalDate updateDate;
    
    @ApiModelProperty(notes = "Profile update time ", required = true)
    private LocalTime updateTime;

}
