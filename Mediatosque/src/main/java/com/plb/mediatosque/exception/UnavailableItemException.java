package com.plb.mediatosque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnavailableItemException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UnavailableItemException(String errorMessage) {
        super(errorMessage);
    }
}
