package com.example.demo_cpgspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo_cpgspringboot.entity.Employee;
import com.example.demo_cpgspringboot.exception.EmployeeAlreadyExistsException;
import com.example.demo_cpgspringboot.exception.NoEmployeePresentException;

public interface EmployeeService {

  Employee saveEmployee(Employee emp) throws EmployeeAlreadyExistsException;
  
  List<Employee> getAllEmployees();
  
  Optional<Employee> getEmployeeById(int id)throws NoEmployeePresentException;
  
 

 Employee updateEmployee(Employee emp);

 String deleteById(int id);
 
 List<Employee> employeeByName( String firstName);
}
