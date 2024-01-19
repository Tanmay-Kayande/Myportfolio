package com.pojo;

public class MessagePojo {

	private int sn;
	private String name;
	private String email;
	private String message;
	private String date;
	
	public MessagePojo(int sn, String name, String email, String message, String date) {
		super();
		this.sn = sn;
		this.name = name;
		this.email = email;
		this.message = message;
		this.date = date;
	}

	public int getSn() {
		return sn;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMessage() {
		return message;
	}

	public String getDate() {
		return date;
	}
	
	
	
	
}
