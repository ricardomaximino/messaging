package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.CampaignChannelsBinding;

public interface CampaignBindingService {
	
	@Output(CampaignChannelsBinding.SEND_CAMPAIGN_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(CampaignChannelsBinding.SEND_CAMPAIGN_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(CampaignChannelsBinding.SEND_CAMPAIGN_DELETED_EVENT)
	MessageChannel sendDeletedEvent();

}
