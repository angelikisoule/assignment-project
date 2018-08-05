package com.soulee.assignmentproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {


	@RequestMapping(value = "/name/first")
	public String getStudent() {
		return "angeliki";
	}

	@RequestMapping(value = "/name/last")
	public String getLast() {
		return "soule";
	}

}
