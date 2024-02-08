package com.hexaware.exception;

public class OverDraftLimitExcededException extends Exception {
	
	public OverDraftLimitExcededException(String message) {
        super(message);
    }
}
