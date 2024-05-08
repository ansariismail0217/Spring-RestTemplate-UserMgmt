package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchUserExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NoSuchUserExistsException() {}
	
	public NoSuchUserExistsException(String msg) {
		super(msg);
	}

}
