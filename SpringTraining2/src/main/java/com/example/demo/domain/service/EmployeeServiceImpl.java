package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Employee;
import com.example.demo.domain.repository.EmployeeRepository;
import com.example.demo.rest.resource.EmployeeQuery;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findByEmployeeQuery(EmployeeQuery query) {
		return employeeRepository.findAll(Specification.where(EmployeeSpecificationHelper.equalsId(query.getId()))
				.and(EmployeeSpecificationHelper.equalsFirstName(query.getFirstName()))
				.and(EmployeeSpecificationHelper.equalsLastName(query.getLastName()))
				.and(EmployeeSpecificationHelper.likeEmail(query.getEmail())));
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElse(new Employee());
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

}
