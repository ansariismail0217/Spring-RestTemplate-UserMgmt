package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {}
	
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}	

}
