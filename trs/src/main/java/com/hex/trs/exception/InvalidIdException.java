package com.hex.trs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class InvalidIdException extends RuntimeException{
    private String message;

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}
    
    
}