package com.dragondesarrollo.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {

	private Date timestamp;
	private String message;
	private String errorMessage;

	public CustomErrorDetails(Date timestamp, String message, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorMessage = errorMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
