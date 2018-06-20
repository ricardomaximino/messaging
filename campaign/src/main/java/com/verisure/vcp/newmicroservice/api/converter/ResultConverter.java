package com.verisure.vcp.newmicroservice.api.converter;

import org.springframework.stereotype.Component;

import com.verisure.vcp.newmicroservice.api.dto.ResultDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Result;


@Component
public class ResultConverter {
	
	public Result toResult(ResultDTO dto) {
		return new Result(dto.getId(), dto.getName(), dto.getDescription());
	}
	
	public ResultDTO toResultDTO(Result result, String operator) {
		return new ResultDTO(operator, result.getId(), result.getName(), result.getDescription());
	}

}
