package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.service.IEmployeeService;


@RestController

public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
 @RequestMapping("/hello")
 public String hello() {
	 return "Hello world";
 }

}
