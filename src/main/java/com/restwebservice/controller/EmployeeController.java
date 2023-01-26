package com.restwebservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restwebservice.exceptions.EmployeeNotFound;
import com.restwebservice.entity.Employee;
import com.restwebservice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{empId}")
	public EntityModel<Employee> getEmployeeById(@PathVariable int empId) throws EmployeeNotFound {
		Employee emp = employeeService.getEmployeeById(empId);
		if (emp == null) {
			throw new EmployeeNotFound("Employee not found!");
		}
		EntityModel<Employee> model = EntityModel.of(emp);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEmployees()).withRel("all-emplyees");
		model.add(link);
		return model;
	}

	@PostMapping("/employees/save")
	public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee newEmployee = employeeService.saveEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{employeeId}").buildAndExpand(newEmployee.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/employees/delete/{empId}")
	public void deleteEmployee(@PathVariable int empId) throws EmployeeNotFound {
		Employee emp = employeeService.getEmployeeById(empId);
		if (emp == null) {
			throw new EmployeeNotFound("Employee not found !");
		}
		employeeService.deleteEmployee(empId);
	}
	
	
	

}
