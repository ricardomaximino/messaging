package com.verisure.vcp.newmicroservice.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class Event {
	
	@Id
	private String id;
	private String type;
	private String key;
	private String operator;
	private LocalDate date;
	private LocalTime time;

}
