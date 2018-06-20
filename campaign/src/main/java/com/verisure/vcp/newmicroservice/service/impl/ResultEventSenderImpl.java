package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.verisure.vcp.newmicroservice.common.utils.ResultChannelsBinding;
import com.verisure.vcp.newmicroservice.domain.entity.Event;
import com.verisure.vcp.newmicroservice.service.ResultBindingService;
import com.verisure.vcp.newmicroservice.service.ResultEventSender;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@EnableBinding(ResultBindingService.class)
public class ResultEventSenderImpl implements ResultEventSender{
	
	private FluxSender createdFluxSender;
	private FluxSender updatedFluxSender;
	private FluxSender deletedFluxSender;
	
	@StreamEmitter
	public void setCreatedFluxSender(@Output(ResultChannelsBinding.SEND_RESULT_CREATED_EVENT) FluxSender sender) {
		this.createdFluxSender = sender;
	}
	
	@StreamEmitter
	public void setUpdatedFluxSender(@Output(ResultChannelsBinding.SEND_RESULT_UPDATED_EVENT) FluxSender sender) {
		this.updatedFluxSender = sender;
	}
	
	@StreamEmitter
	public void setdDeletedFluxSender(@Output(ResultChannelsBinding.SEND_RESULT_DELETED_EVENT) FluxSender sender) {
		this.deletedFluxSender = sender;
	}

	@Override
	public void sendCreatedEvent(Event event) {
		LOGGER.debug("SENDING RESULT CREATED EVENT");
		createdFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendUpdatedEvent(Event event) {
		LOGGER.debug("SENDING RESULT UPDATED EVENT");
		updatedFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendDeletedEvent(Event event) {
		LOGGER.debug("SENDING RESULT DELETED EVENT");
		deletedFluxSender.send(Flux.just(event));
	}
}
