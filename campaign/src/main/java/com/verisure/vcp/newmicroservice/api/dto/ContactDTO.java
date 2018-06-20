package com.verisure.vcp.newmicroservice.api.dto;

import java.util.List;

import com.verisure.vcp.newmicroservice.common.utils.EventMessage;
import com.verisure.vcp.newmicroservice.domain.entity.Activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDTO extends BaseDTO implements EventMessage{

	@ApiModelProperty(notes = "Operator id", required = true)
	private String operator;
	
	@ApiModelProperty(notes = "Contact id", required = true)
	private String id;
	
	@ApiModelProperty(notes = "The way to contact", required = true)
	private String contact;
	
	@ApiModelProperty(notes = "Profile id", required = true)
	private String profileId;
	
	@ApiModelProperty(notes = "Contact activity list", required = true)
	private List<Activity> activityList;
	
	@ApiModelProperty(notes = "Contact result id", required = true)
	private String resultId;
	
	@ApiModelProperty(notes = "Origin of the  contact", required = true)
	private String origin;
}
