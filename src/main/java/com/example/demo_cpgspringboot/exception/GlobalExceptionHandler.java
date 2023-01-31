package com.example.demo_cpgspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=EmployeeAlreadyExistsException.class)
	public ResponseEntity<String> EmployeeAlreadyExistsException(EmployeeAlreadyExistsException user){
		return new ResponseEntity<String>("User already exists in db.Please try again",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=NoEmployeePresentException.class)
	public ResponseEntity<String> NoEmployeePresentException(NoEmployeePresentException user){
		return new ResponseEntity<String>("No Employee exists in db.please enter valid ID",HttpStatus.OK);
	}
}
