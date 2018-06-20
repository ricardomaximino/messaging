package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verisure.vcp.newmicroservice.api.converter.SkillsConverter;
import com.verisure.vcp.newmicroservice.api.dto.SkillsDTO;
import com.verisure.vcp.newmicroservice.common.utils.EventBuilder;
import com.verisure.vcp.newmicroservice.domain.entity.Skills;
import com.verisure.vcp.newmicroservice.domain.repository.SkillsRepository;
import com.verisure.vcp.newmicroservice.service.SkillsEventSender;
import com.verisure.vcp.newmicroservice.service.SkillsService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SkillsServiceImpl implements SkillsService{
	
	@Autowired
	private SkillsRepository skillsRepository;
	
	@Autowired
	private SkillsEventSender sender;
	
	@Autowired
	private SkillsConverter converter;

	@Override
	public Mono<Skills> save(SkillsDTO skillsDTO) {
		if(skillsDTO.getId() != null && !skillsDTO.getId().isEmpty()) {
			return skillsRepository.existsById(skillsDTO.getId()).flatMap(exist -> {
				if(exist) {
					LOGGER.debug("UPDATE SKILLS ON THE DATABASE");
					sender.sendUpdatedEvent(EventBuilder.updatedEvent(skillsDTO));
					return skillsRepository.save(converter.toSkills(skillsDTO));
				}else {
					LOGGER.debug("CREATE SKILLS ON THE DATABASE");
					sender.sendCreatedEvent(EventBuilder.createdEvent(skillsDTO));
					return skillsRepository.save(converter.toSkills(skillsDTO));
				}
			});
		}else {
			return skillsRepository.save(converter.toSkills(skillsDTO)).map(p -> {
				LOGGER.debug("CREATE PROFILE ON THE DATABASE");
				sender.sendCreatedEvent(EventBuilder.createdEvent(skillsDTO));
				return p;
			});
		}
	}

	@Override
	public Mono<Skills> findById(String id) {
		return skillsRepository.findById(id);
	}

	@Override
	public Mono<Boolean> deleteById(String operatorId, String id) {
		return skillsRepository.existsById(id).flatMap(exist -> {
			if(exist) {
				skillsRepository.findById(id).subscribe(s -> 	sender.sendDeletedEvent(EventBuilder.deletedEvent(converter.toSkillsDTO(s, operatorId))));
				LOGGER.debug("DELETE SKILLS ON THE DATABASE");
				return skillsRepository.deleteById(id).map(s -> true);
			}
			return Mono.just(new Boolean(false));
		});
	}

	@Override
	public Flux<Skills> findAll() {
		return skillsRepository.findAll();
	}

}

