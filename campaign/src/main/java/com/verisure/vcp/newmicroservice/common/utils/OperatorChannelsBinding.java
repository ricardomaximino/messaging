package com.verisure.vcp.newmicroservice.common.utils;

public class OperatorChannelsBinding {
	
	public static final String SEND_OPERATOR_CREATED_EVENT = "sendOperatorCreatedEvent";
	public static final String SEND_OPERATOR_UPDATED_EVENT = "sendOperatorUpdatedEvent";
	public static final String SEND_OPERATOR_DELETED_EVENT = "sendOperatorDeletedEvent";
	
	private OperatorChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}

}
