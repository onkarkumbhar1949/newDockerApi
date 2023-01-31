package com.example.demo_cpgspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_cpgspringboot.entity.Employee;
import com.example.demo_cpgspringboot.exception.EmployeeAlreadyExistsException;
import com.example.demo_cpgspringboot.exception.NoEmployeePresentException;
import com.example.demo_cpgspringboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) throws EmployeeAlreadyExistsException {
		Employee savedEmp=empServ.saveEmployee(emp);
		return new ResponseEntity<Employee>(savedEmp,HttpStatus.CREATED);
	}
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees=empServ.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id) throws NoEmployeePresentException{
		Optional<Employee> emp=empServ.getEmployeeById(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee upEmp=empServ.updateEmployee(emp);
		return new ResponseEntity<>(upEmp,HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		String msg=empServ.deleteById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@GetMapping("getEmployeeByName/{firstName}")
	public List<Employee>employeeByName(@PathVariable String firstName){
		List<Employee> em=empServ.employeeByName(firstName);
		return em;
	}
	
	
}
