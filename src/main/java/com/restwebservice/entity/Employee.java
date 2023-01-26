package com.restwebservice.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, max = 5, message = "Invalid chars for name")
	@Column
	private String name;
	
	@Email
	@Column
	private String email;

	@OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
	private List<Department> allDepartments;

	public Employee() {
	}

	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Department> getAllDepartments() {
		return allDepartments;
	}
	public void setAllDepartments(List<Department> allDepartments) {
		this.allDepartments = allDepartments;
	}
}
