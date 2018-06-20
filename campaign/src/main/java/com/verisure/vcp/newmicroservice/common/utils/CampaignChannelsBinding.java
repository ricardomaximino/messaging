package com.verisure.vcp.newmicroservice.common.utils;

public class CampaignChannelsBinding {
	
	public static final String SEND_CAMPAIGN_CREATED_EVENT = "sendCampaignCreatedEvent";
	public static final String SEND_CAMPAIGN_UPDATED_EVENT = "sendCampaignUpdatedEvent";
	public static final String SEND_CAMPAIGN_DELETED_EVENT = "sendCampaignDeletedEvent";	
	
	private CampaignChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}

}
