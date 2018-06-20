package com.verisure.vcp.newmicroservice.common.utils;

public class ActivityChannelsBinding {
	
	public static final String SEND_ACTIVITY_CREATED_EVENT = "sendActivityCreatedEvent";
	public static final String SEND_ACTIVITY_UPDATED_EVENT = "sendActivityUpdatedEvent";
	public static final String SEND_ACTIVITY_DELETED_EVENT = "sendActivityDeletedEvent";

	private ActivityChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}
}
