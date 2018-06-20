package com.brasajava.springbootreactivewebsockettwo.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact {
	
	@Id
	private String id;
	private String phone;
	private String email;
	private LocalDate createDate;
	private LocalTime createTime;
	private LocalDate updateDate;
	private LocalTime updateTime;
	
	
	public Contact() {	}
	public Contact(String phone, String email, LocalDate createDate, LocalTime createTime, LocalDate updateDate, LocalTime updateTime) {
		this.phone = phone;
		this.email = email;
		this.createDate = createDate;
		this.createTime = createTime;
		this.updateDate = updateDate;
		this.updateTime = updateTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalTime createTime) {
		this.createTime = createTime;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public LocalTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalTime updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", phone=" + phone + ", email=" + email + ", createDate=" + createDate
				+ ", createTime=" + createTime + ", updateDate=" + updateDate + ", updateTime=" + updateTime + "]";
	}
	
}
