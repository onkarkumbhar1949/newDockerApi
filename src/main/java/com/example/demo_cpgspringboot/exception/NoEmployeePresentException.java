package com.example.demo_cpgspringboot.exception;

public class NoEmployeePresentException extends Exception{
	private String msg;

	public NoEmployeePresentException(String msg) {
		super();
		this.msg = msg;
	}

	public NoEmployeePresentException() {
		super();
	}
	

}
