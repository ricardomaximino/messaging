package com.verisure.vcp.newmicroservice.api.dto;

import java.util.List;

import com.verisure.vcp.newmicroservice.common.utils.EventMessage;
import com.verisure.vcp.newmicroservice.domain.entity.Skills;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperatorDTO extends BaseDTO implements EventMessage{

	@ApiModelProperty(notes = "Transaction operator id", required = true)
	private String operator;
	
	@ApiModelProperty(notes = "Operator id", required = true)
	private String id;
	
	@ApiModelProperty(notes = "Operator name", required = true)
	private String name;
	
	@ApiModelProperty(notes = "Operator skills list", required = true)
	private List<Skills> skillsList;
}
