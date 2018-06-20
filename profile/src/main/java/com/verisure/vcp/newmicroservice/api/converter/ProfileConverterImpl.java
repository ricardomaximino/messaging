package com.verisure.vcp.newmicroservice.api.converter;

import org.springframework.stereotype.Component;

import com.verisure.vcp.newmicroservice.api.dto.ProfileDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Profile;

@Component
public class ProfileConverterImpl implements ProfileConverter {

	@Override
	public ProfileDTO toProfileDTO(Profile profile) {
		return new ProfileDTO("", profile.getId(), profile.getName(), profile.getLastname(), profile.getBirthday(), profile.getDetails(), profile.getCreateDate(), profile.getCreateTime(), profile.getUpdateDate(), profile.getUpdateTime());
	}

	@Override
	public Profile toProfile(ProfileDTO dto) {
		return new Profile(dto.getId(), dto.getName(), dto.getLastname(), dto.getBirthday(), dto.getDetails(), dto.getCreateDate(), dto.getCreateTime(), dto.getUpdateDate(), dto.getUpdateTime());
	}

	
}
