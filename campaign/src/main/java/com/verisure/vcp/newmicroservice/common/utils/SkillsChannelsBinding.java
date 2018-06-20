package com.verisure.vcp.newmicroservice.common.utils;

public class SkillsChannelsBinding {
	
	public static final String SEND_SKILLS_CREATED_EVENT = "sendSkillsCreatedEvent";
	public static final String SEND_SKILLS_UPDATED_EVENT = "sendSkillsUpdatedEvent";
	public static final String SEND_SKILLS_DELETED_EVENT = "sendSkillsDeletedEvent";
	

	private SkillsChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}
}
