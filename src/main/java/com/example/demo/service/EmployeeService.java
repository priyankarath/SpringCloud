package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.model.EmployeeModel;

@Service
public class EmployeeService {
	
	public EmployeeModel getEmployee() throws EmployeeServiceException {
		EmployeeModel emp = new EmployeeModel();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		return emp;
	}
	
	public EmployeeModel getEmployeeNull() throws EmployeeServiceException {
		return null;
	}
	
	public EmployeeModel getEmployeeException() throws EmployeeServiceException {
		throw new EmployeeServiceException();
	}

}
