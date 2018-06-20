package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.SkillsChannelsBinding;

public interface SkillsBindingService {

	@Output(SkillsChannelsBinding.SEND_SKILLS_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(SkillsChannelsBinding.SEND_SKILLS_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(SkillsChannelsBinding.SEND_SKILLS_DELETED_EVENT)
	MessageChannel sendDeletedEvent();
}
