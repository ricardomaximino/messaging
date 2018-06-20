package com.brasajava.rabbitstreamreactiveone.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

	@Id
	private String id;
	private String name;
	private String lastname;
	private String email;
	private LocalDate createDate;
	private LocalDate updateDate;
	private LocalTime createTime;
	private LocalTime updateTime;
	
	public Person() {}
	
	
	public Person(String name, String lastname, String email, LocalDate createDate, LocalDate updateDate,
			LocalTime createTime, LocalTime updateTime) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public LocalTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalTime createTime) {
		this.createTime = createTime;
	}
	public LocalTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}
