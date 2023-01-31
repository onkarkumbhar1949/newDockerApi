package com.example.demo_cpgspringboot.exception;

public class EmployeeAlreadyExistsException extends Exception{

	private String msg;
	
	public EmployeeAlreadyExistsException(String msg) {
		super();
		this.msg=msg;
	}
	public EmployeeAlreadyExistsException() {
		super();
	}
}
