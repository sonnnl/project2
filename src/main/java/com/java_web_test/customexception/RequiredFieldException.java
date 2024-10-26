package com.java_web_test.customexception;

public class RequiredFieldException extends Exception{

	public RequiredFieldException(String message) {
		super(message);
	}
	
}
