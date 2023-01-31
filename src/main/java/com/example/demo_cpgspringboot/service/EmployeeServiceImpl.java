package com.example.demo_cpgspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_cpgspringboot.entity.Employee;
import com.example.demo_cpgspringboot.exception.EmployeeAlreadyExistsException;
import com.example.demo_cpgspringboot.exception.NoEmployeePresentException;
import com.example.demo_cpgspringboot.respository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee saveEmployee(Employee emp)throws EmployeeAlreadyExistsException {
		if(empRepo.existsById(emp.getId()))
			throw new EmployeeAlreadyExistsException();
		Employee savedEmp=empRepo.save(emp);
		return savedEmp;
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> employees=empRepo.findAll();
		return employees;
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int id) throws NoEmployeePresentException{
		if(empRepo.existsById(id)==false)
			 throw new NoEmployeePresentException();
		Optional<Employee> emp=empRepo.findById(id);
		return emp;
	}
	@Override
	public Employee updateEmployee(Employee emp) {
		Employee upEmp=empRepo.save(emp);
		return upEmp;
	}
	
	@Override
	public String deleteById(int id) {
		empRepo.deleteById(id);
		return"delete succesfully";
	}
	@Override
	public List<Employee> employeeByName(String firstName){
		List<Employee> list=empRepo.findByName(firstName);
		return list;
	}
	
}
