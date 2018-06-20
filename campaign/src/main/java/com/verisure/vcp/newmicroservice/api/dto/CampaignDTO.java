package com.verisure.vcp.newmicroservice.api.dto;

import java.util.List;

import com.verisure.vcp.newmicroservice.common.utils.EventMessage;
import com.verisure.vcp.newmicroservice.domain.entity.Contact;
import com.verisure.vcp.newmicroservice.domain.entity.Operator;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignDTO extends BaseDTO implements EventMessage{

	@ApiModelProperty(notes = "Operator id", required = true)
	private String operator;
    @ApiModelProperty(notes = "Campaign id", required = true)
    private String id;
    @ApiModelProperty(notes = "Campaign name", required = true)
    private String name;
    @ApiModelProperty(notes = "Campaign description", required = true)
    private String description;
    @ApiModelProperty(notes = "Campaign operator list", required = true)
    private List<Operator> OperatorList;
    @ApiModelProperty(notes = "Campaign contact list", required = true)
    private List<Contact> ContactList;
}
