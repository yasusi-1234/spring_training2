package com.example.demo.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.repository.EmployeeRepository;

@Controller
@RequestMapping("sample")
public class SampleController {

	private final EmployeeRepository repository;

	@Autowired
	public SampleController(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public String getEmployee() {
		return "index";
	}
}
