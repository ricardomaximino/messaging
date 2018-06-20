package com.brasajava.springbootreactivewebsockettwo.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event {

	@Id
	private String id;
	private String type;
	private String key;
	private Object object;
	private LocalDate createDate;
	private LocalTime createTime;
	
	
	public Event() {}	
	public Event(String type, String key, Object object, LocalDate createDate, LocalTime createTime) {
		this.type = type;
		this.key = key;
		this.object = object;
		this.createDate = createDate;
		this.createTime = createTime;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
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
	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", key=" + key + ", object=" + object + ", createDate="
				+ createDate + ", createTime=" + createTime + "]";
	}
	
}
