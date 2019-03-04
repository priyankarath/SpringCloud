package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public EmployeeModel getEmployee() throws ResourceNotFoundException,EmployeeServiceException{
		EmployeeModel emp = null;
		try {
			emp = employeeService.getEmployee();
			if(emp==null) {
				throw new ResourceNotFoundException("Employee Not Found");
			}
			return emp;
		} catch (EmployeeServiceException e) {
			throw new EmployeeServiceException("Internal Server Exception");
		}
		
	}
	
	@RequestMapping(value = "/employee2", method = RequestMethod.GET)
	public EmployeeModel getEmp2() throws ResourceNotFoundException, EmployeeServiceException {
		try {
			EmployeeModel emp = employeeService.getEmployeeNull();
			if (emp == null) {
				throw new ResourceNotFoundException("Employee not found");
			}
			return emp;
		} catch (EmployeeServiceException e) {
			throw new EmployeeServiceException("Internal Server Exception while getting exception");
		}
	}
	
	@RequestMapping(value = "/employee3", method = RequestMethod.GET)
	public EmployeeModel getEmp3() throws ResourceNotFoundException, EmployeeServiceException {
		try {
			EmployeeModel emp = employeeService.getEmployeeException();
			if (emp == null) {
				throw new ResourceNotFoundException("Employee not found");
			}
			return emp;
		} catch (EmployeeServiceException e) {
			throw new EmployeeServiceException("Internal Server Exception while getting exception");
		}
	}

}
