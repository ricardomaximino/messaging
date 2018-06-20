package com.verisure.vcp.newmicroservice.domain.entity;

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
public class Skills {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String description;

}
