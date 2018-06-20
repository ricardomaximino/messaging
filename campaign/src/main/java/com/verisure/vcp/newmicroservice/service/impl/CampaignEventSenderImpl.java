package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.verisure.vcp.newmicroservice.common.utils.CampaignChannelsBinding;
import com.verisure.vcp.newmicroservice.domain.entity.Event;
import com.verisure.vcp.newmicroservice.service.CampaignBindingService;
import com.verisure.vcp.newmicroservice.service.CampaignEventSender;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
@Slf4j
@EnableBinding(CampaignBindingService.class)
public class CampaignEventSenderImpl implements CampaignEventSender{
	
	private FluxSender createdFluxSender;
	private FluxSender updatedFluxSender;
	private FluxSender deletedFluxSender;
	
	@StreamEmitter
	public void setCreatedFluxSender(@Output(CampaignChannelsBinding.SEND_CAMPAIGN_CREATED_EVENT) FluxSender sender) {
		this.createdFluxSender = sender;
	}
	
	@StreamEmitter
	public void setUpdatedFluxSender(@Output(CampaignChannelsBinding.SEND_CAMPAIGN_UPDATED_EVENT) FluxSender sender) {
		this.updatedFluxSender = sender;
	}
	
	@StreamEmitter
	public void setdDeletedFluxSender(@Output(CampaignChannelsBinding.SEND_CAMPAIGN_DELETED_EVENT) FluxSender sender) {
		this.deletedFluxSender = sender;
	}

	@Override
	public void sendCreatedEvent(Event event) {
		LOGGER.debug("SENDING CAMPAIGN CREATED EVENT");
		createdFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendUpdatedEvent(Event event) {
		LOGGER.debug("SENDING CAMPAIGN UPDATED EVENT");
		updatedFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendDeletedEvent(Event event) {
		LOGGER.debug("SENDING CAMPAIGN DELETED EVENT");
		deletedFluxSender.send(Flux.just(event));
	}
}
