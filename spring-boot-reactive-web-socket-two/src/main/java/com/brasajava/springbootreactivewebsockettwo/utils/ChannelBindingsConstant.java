package com.brasajava.springbootreactivewebsockettwo.utils;

public class ChannelBindingsConstant {
	
	public static final String SEND_CONTACT_CREATED = "sendContactCreated";
	public static final String SEND_CONTACT_UPDATED = "sendContactUpdated";
	public static final String SEND_CONTACT_DELETED = "sendContactDeleted";
	
	public static final String LISTEN_CONTACT_CREATED = "listenContactCreated";
	public static final String LISTEN_CONTACT_UPDATED = "listenContactUpdated";
	public static final String LISTEN_CONTACT_DELETED = "listenContactDeleted";
	
	
	public static final String SEND_PERSON_CREATED = "sendPersonCreated";
	public static final String SEND_PERSON_UPDATED = "sendPersonUpdated";
	public static final String SEND_PERSON_DELETED = "sendPersonDeleted";
	
	public static final String LISTEN_PERSON_CREATED = "listenPersonCreated";
	public static final String LISTEN_PERSON_UPDATED = "listenPersonUpdated";
	public static final String LISTEN_PERSON_DELETED = "listenPersonDeleted";
	
	private ChannelBindingsConstant() throws IllegalAccessException{
		throw new IllegalAccessException("This class should not be initialized");
	}
	

}
