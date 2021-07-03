package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.model.Employee;
import com.example.demo.rest.resource.EmployeeQuery;

public interface EmployeeService {

	public Employee findById(Long id);

	public List<Employee> findAllEmployee();

	List<Employee> findByEmployeeQuery(EmployeeQuery query);
}
