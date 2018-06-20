package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verisure.vcp.newmicroservice.api.converter.ResultConverter;
import com.verisure.vcp.newmicroservice.api.dto.ResultDTO;
import com.verisure.vcp.newmicroservice.common.utils.EventBuilder;
import com.verisure.vcp.newmicroservice.domain.entity.Result;
import com.verisure.vcp.newmicroservice.domain.repository.ResultRepository;
import com.verisure.vcp.newmicroservice.service.ResultEventSender;
import com.verisure.vcp.newmicroservice.service.ResultService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private ResultConverter converter;
	
	@Autowired
	private ResultEventSender sender;

	@Override
	public Mono<Result> save(ResultDTO resultDTO) {
		if(resultDTO.getId() != null && !resultDTO.getId().isEmpty()) {
			return resultRepository.existsById(resultDTO.getId()).flatMap(exist -> {
				if(exist) {
					LOGGER.debug("UPDATE RESULT ON THE DATABASE");
					sender.sendUpdatedEvent(EventBuilder.updatedEvent(resultDTO));
					return resultRepository.save(converter.toResult(resultDTO));
				}else {
					LOGGER.debug("CREATE RESULT ON THE DATABASE");
					sender.sendCreatedEvent(EventBuilder.createdEvent(resultDTO));
					return resultRepository.save(converter.toResult(resultDTO));
				}
			});
		}else {
			return resultRepository.save(converter.toResult(resultDTO)).map(r -> {
				LOGGER.debug("CREATE RSULT ON THE DATABASE");
				sender.sendCreatedEvent(EventBuilder.createdEvent(resultDTO));
				return r;
			});
		}
	}

	@Override
	public Mono<Result> findById(String id) {
		return resultRepository.findById(id);
	}

	@Override
	public Mono<Boolean> deleteById(String operatorId, String id) {
		return resultRepository.existsById(id).flatMap(exist -> {
			if(exist) {
				resultRepository.findById(id).subscribe(s -> 	sender.sendDeletedEvent(EventBuilder.deletedEvent(converter.toResultDTO(s, operatorId))));
				LOGGER.debug("DELETE RESULT ON THE DATABASE");
				return resultRepository.deleteById(id).map(s -> true);
			}
			return Mono.just(new Boolean(false));
		});
	}

	@Override
	public Flux<Result> findAll() {
		return resultRepository.findAll();
	}
	
	

}
