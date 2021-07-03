package com.example.demo.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.domain.model.Employee;
import com.example.demo.domain.service.EmployeeService;
import com.example.demo.rest.resource.EmployeeQuery;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleRestController {

	private final EmployeeService employeeService;

	private final ModelMapper modelMapper;

	@Autowired
	public SampleRestController(EmployeeService employeeService, ModelMapper modelMapper) {
		super();
		this.employeeService = employeeService;
		this.modelMapper = modelMapper;
	}

	@ApiOperation(value = "ユーザー情報全件取得", notes = "登録されているユーザー情報を全件取得します")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ユーザー情報全件", response = Employee[].class) })
	@GetMapping
	public List<Employee> getFindEmpList() {
		return employeeService.findAllEmployee();
	}

	@ApiOperation(value = "ユーザ情報取得", notes = "指定されたID情報を持つユーザー情報1件")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "１件のユーザー情報", response = Employee.class) })
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.findById(id);
	}

	@PostMapping
	public List<Employee> postFindEmpList(@RequestBody EmployeeQuery query) {
		if (query != null) {
			log.info(query.toString());
		}
		return employeeService.findByEmployeeQuery(query);
	}

	@GetMapping("/find")
	public List<Employee> findEmpList1(UriComponentsBuilder builder) {
		log.info(builder.toUriString());
		log.info(builder.path("/api/employees").toUriString());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee[]> entity = restTemplate.getForEntity(builder.toUriString(), Employee[].class);
		Arrays.stream(entity.getBody()).forEach(emp -> log.info(emp.toString()));
		return Arrays.stream(entity.getBody()).collect(Collectors.toList());
	}

	@GetMapping("find2")
	public List<Employee> findEmpList2(UriComponentsBuilder builder) {
		RestTemplate restTemplate = new RestTemplate();
		EmployeeQuery query = new EmployeeQuery();
		query.setId(1L);
		ResponseEntity<Employee[]> entity = restTemplate.postForEntity(builder.path("/api/employees").toUriString(),
				query, Employee[].class);
		Arrays.stream(entity.getBody()).forEach(emp -> log.info(emp.toString()));
		URI uri = restTemplate.postForLocation(builder.toUriString(), query);
		System.out.println(uri);
		return Arrays.stream(entity.getBody()).collect(Collectors.toList());
	}

}
