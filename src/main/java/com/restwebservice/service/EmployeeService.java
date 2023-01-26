package com.restwebservice.service;

import java.util.ArrayList;
import java.util.List;

import com.restwebservice.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restwebservice.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeService() {
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}

	public Employee getEmployeeById(int empId) {
		return employeeRepository.findById(empId).get();
	}

	public Employee saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	public void deleteEmployee(int empId){
		employeeRepository.deleteById(empId);
	}




}
