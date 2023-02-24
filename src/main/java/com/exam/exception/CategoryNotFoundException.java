package com.exam.exception;

public class CategoryNotFoundException extends Exception{
	private String message;

	public CategoryNotFoundException() {}
	public CategoryNotFoundException(String message) {
		super(message);
		this.message=message;
	}
}