package com.verisure.vcp.newmicroservice.api.converter;

import com.verisure.vcp.newmicroservice.api.dto.ProfileDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Sample converter used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */

@Mapper(componentModel = "spring")
public interface ProfileConverter {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastname", target = "lastname"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "details", target = "details"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "createTime", target = "createTime"),
            @Mapping(source = "updateDate", target = "updateDate"),
            @Mapping(source = "updateTime", target = "updateTime")
    })
    ProfileDTO toProfileDTO(Profile profile);

    @Mappings({
    	@Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "lastname", target = "lastname"),
        @Mapping(source = "birthday", target = "birthday"),
        @Mapping(source = "details", target = "details"),
        @Mapping(source = "createDate", target = "createDate"),
        @Mapping(source = "createTime", target = "createTime"),
        @Mapping(source = "updateDate", target = "updateDate"),
        @Mapping(source = "updateTime", target = "updateTime")
    })
    Profile toProfile(ProfileDTO dto);

}