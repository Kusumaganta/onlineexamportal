package com.exam.exception;

public class CategoryAlreadyExistsException extends Exception{
	private String message;
	public CategoryAlreadyExistsException() {}
	public CategoryAlreadyExistsException(String message) {
		super(message);
		this.message=message;
	}
	}
