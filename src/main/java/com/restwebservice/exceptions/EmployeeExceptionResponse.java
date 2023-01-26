package com.restwebservice.exceptions;

import java.util.Date;

public class EmployeeExceptionResponse {

	private String errorMsg, description;
	private Date dateAndTime;

	public EmployeeExceptionResponse(String errorMsg, String description, Date dateAndTime) {
		this.errorMsg = errorMsg;
		this.description = description;
		this.dateAndTime = dateAndTime;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}
