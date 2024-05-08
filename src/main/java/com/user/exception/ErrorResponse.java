package com.user.exception;

public class ErrorResponse {

	private String error;
	private String message;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String statusCode) {
		this.error = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}