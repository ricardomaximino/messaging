package com.verisure.vcp.newmicroservice.api.converter;


import org.springframework.stereotype.Component;

import com.verisure.vcp.newmicroservice.api.dto.OperatorDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Operator;

@Component
public class OperatorConverter {
	
	public Operator toOperator(OperatorDTO dto) {
		return new Operator(dto.getId(), dto.getName(), dto.getSkillsList());
	}
	
	public OperatorDTO toOperatorDTO(Operator operator, String operatorId) {
		return new OperatorDTO(operatorId, operator.getId(), operator.getName(), operator.getSkillsList());
	}

}
