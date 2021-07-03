package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminRestController {

	@GetMapping("sample1")
	public String sample1() {
		return "sample1";
	}

	@GetMapping("sample2")
	public String sample2() {
		return "sample2";
	}

	@PostMapping("sample1")
	public String postSample1() {
		return "post_sample1";
	}
}
