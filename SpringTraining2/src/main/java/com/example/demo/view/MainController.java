package com.example.demo.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {

	@GetMapping
	public String getMain(Model model) {
		model.addAttribute("title", "Main");
		return "main";
	}

	@GetMapping("other")
	public String oter(Model model) {
		model.addAttribute("title", "Other");
		return "other";
	}
}
