package com.fuze.coreuc.schiaparelli.exceptions;

public class InvalidRequestException extends Exception {
	private static final String PREFIX = "BAD_REQ: ";
	public InvalidRequestException(String s, Exception e) {
		super(PREFIX + s, e);
	}

	public InvalidRequestException(String s) {
		super(PREFIX + s);
	}
}
