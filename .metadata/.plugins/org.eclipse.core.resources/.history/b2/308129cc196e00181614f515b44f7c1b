package com.brasajava.rabbitstreamreceiverone.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ContactEvent {
	@Id
	private String id;
	private String type;
	private String contactId;
	private Contact contact;
	private LocalDate sendDate;
	private LocalDate receiveDate;
	private LocalTime sendTime;
	private LocalTime receiveTime;
	
	public ContactEvent() {	}
	
	

	public ContactEvent(String id, String type, String contactId, Contact contact, LocalDate sendDate,
			LocalDate receiveDate, LocalTime sendTime, LocalTime receiveTime) {
		super();
		this.id = id;
		this.type = type;
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
		return "ContactEvent [id=" + id + ", type=" + type + ", contactId=" + contactId + ", contact=" + contact
				+ ", sendDate=" + sendDate + ", receiveDate=" + receiveDate + ", sendTime=" + sendTime
				+ ", receiveTime=" + receiveTime + "]";
	}
	
}