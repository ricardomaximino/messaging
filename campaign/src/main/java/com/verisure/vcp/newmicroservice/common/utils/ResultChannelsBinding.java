package com.verisure.vcp.newmicroservice.common.utils;

public class ResultChannelsBinding {

	public static final String SEND_RESULT_CREATED_EVENT = "sendResultCreatedEvent";
	public static final String SEND_RESULT_UPDATED_EVENT = "sendResultUpdatedEvent";
	public static final String SEND_RESULT_DELETED_EVENT = "sendResultDeletedEvent";
	
	private ResultChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}
}
