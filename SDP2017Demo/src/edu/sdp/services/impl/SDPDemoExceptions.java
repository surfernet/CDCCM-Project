package edu.sdp.services.impl;

public class SDPDemoExceptions extends Exception {

	private String errorMessage;

	public SDPDemoExceptions(String message) {
		super(message);
		errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
