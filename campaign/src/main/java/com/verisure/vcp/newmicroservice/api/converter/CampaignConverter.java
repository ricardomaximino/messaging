package com.verisure.vcp.newmicroservice.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.verisure.vcp.newmicroservice.api.dto.CampaignDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Campaign;

/**
 * Sample converter used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Mapper(componentModel = "spring")
public interface CampaignConverter {

    @Mappings({
            @Mapping(source = "test", target = "testOne")
           
    })
    CampaignDTO toItemDto(Campaign item);

    @Mappings({
            @Mapping(source = "testOne", target = "test")
    })
    Campaign toApplicationItem(CampaignDTO entry);

}