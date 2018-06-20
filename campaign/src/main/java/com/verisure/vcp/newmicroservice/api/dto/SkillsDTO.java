package com.verisure.vcp.newmicroservice.api.dto;

import com.verisure.vcp.newmicroservice.common.utils.EventMessage;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillsDTO extends BaseDTO implements EventMessage{

	@ApiModelProperty(notes = "Operator id", required = true)
	private String operator;
	
	@ApiModelProperty(notes = "Skills id", required = true)
	private String id;
	
	@ApiModelProperty(notes = "Skills name", required = true)
	private String name;
	
	@ApiModelProperty(notes = "Skills description", required = true)
	private String description;
}
