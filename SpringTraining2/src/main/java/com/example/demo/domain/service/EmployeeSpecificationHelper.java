package com.example.demo.domain.service;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.domain.model.Employee;
import com.example.demo.domain.model.Employee_;

public class EmployeeSpecificationHelper {

	public static Specification<Employee> equalsId(Long id) {
		return id == null || id < 1 ? null : (root, query, cb) -> cb.equal(root.get(Employee_.id), id);
	}

	public static Specification<Employee> equalsFirstName(String firstName) {
		return firstName == null || firstName.isBlank() ? null
				: (root, query, cb) -> cb.equal(root.get(Employee_.firstName), firstName);
	}

	public static Specification<Employee> equalsLastName(String lastName) {
		return lastName == null || lastName.isBlank() ? null
				: (root, query, cb) -> cb.equal(root.get(Employee_.lastName), lastName);
	}

	public static Specification<Employee> likeEmail(String email) {
		return email == null || email.isBlank() ? null
				: (root, query, cb) -> cb.like(root.get(Employee_.email), "%" + email + "%");
	}

//	private Long id;
//	private String firstName;
//	private String lastName;
//	private String email;
}
