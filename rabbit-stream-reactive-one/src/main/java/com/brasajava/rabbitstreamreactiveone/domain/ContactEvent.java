package com.brasajava.rabbitstreamreactiveone.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ContactEvent {
	
	@Id
	private String id;
	private String type;
	private String description;
	private String contactId;
	private Contact contact;
	private LocalDate sendDate;
	private LocalDate receiveDate;
	private LocalTime sendTime;
	private LocalTime receiveTime;
	
	
	public ContactEvent() {	}	
	public ContactEvent(String type, String description, String contactId, Contact contact,
			LocalDate sendDate, LocalDate receiveDate, LocalTime sendTime, LocalTime receiveTime) {
		this.type = type;
		this.description = description;
		this.contactId = contactId;
		this.contact = contact;
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
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "ContactEvent [id=" + id + ", type=" + type + ", description=" + description + ", contactId=" + contactId
				+ ", contact=" + contact + ", sendDate=" + sendDate + ", receiveDate=" + receiveDate + ", sendTime="
				+ sendTime + ", receiveTime=" + receiveTime + "]";
	}

}
