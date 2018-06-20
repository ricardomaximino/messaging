package com.verisure.vcp.newmicroservice.domain.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Contact {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String contact;
	private String profileId;
	private List<Activity> activityList;
	private String resultId;
	private String origin;
}
