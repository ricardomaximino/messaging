package com.brasajava.rabbitstreamreactiveone.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PersonEvent {

	@Id
	private String id;
	private String type;
	private String description;
	private String personId;
	private Person person;
	private LocalDate sendDate;
	private LocalDate receiveDate;
	private LocalTime sendTime;
	private LocalTime receiveTime;
	
	
	
	public PersonEvent() {}
	
	public PersonEvent(String type, String description, String personId, Person person, LocalDate sendDate,
			LocalDate receiveDate, LocalTime sendTime, LocalTime receiveTime) {
		this.type = type;
		this.description = description;
		this.personId = personId;
		this.person = person;
		this.sendDate = sendDate;
		this.receiveDate = receiveDate;
		this.sendTime = sendTime;
		this.receiveTime = receiveTime;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public LocalDate getSendDate() {
		return sendDate;
	}
	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}
	public LocalDate getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(LocalDate receiveDate) {
		this.receiveDate = receiveDate;
	}
	public LocalTime getSendTime() {
		return sendTime;
	}
	public void setSendTime(LocalTime sendTime) {
		this.sendTime = sendTime;
	}
	public LocalTime getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(LocalTime receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Override
	public String toString() {
		return "PersonEvent [id=" + id + ", type=" + type + ", description=" + description + ", personId=" + personId
				+ ", person=" + person + ", sendDate=" + sendDate + ", receiveDate=" + receiveDate + ", sendTime="
				+ sendTime + ", receiveTime=" + receiveTime + "]";
	}
	
}
