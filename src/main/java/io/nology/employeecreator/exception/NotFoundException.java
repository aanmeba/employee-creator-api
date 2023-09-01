package io.nology.employeecreator.exception;

public class NotFoundException extends RuntimeException {
	
	private String message;
	
	public NotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
