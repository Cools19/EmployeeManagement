package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.IEmployeeService;


@RestController

public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
 @RequestMapping("/hello")
 public String hello() {
	 return "Hello world";
 }

 @PostMapping("/employee")
 Integer createEmployee(@RequestBody Employee employee ) {
	 Integer id = employeeService.saveEmployee(employee);
	 System.out.println(id);
	 return id;
 }
 
 @GetMapping("/allemployees")
 public List<Employee> getEmployees(){
	 return employeeService.getAllEmployees();
 }
 
 @GetMapping("/getemployee/{id}")
 public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id){
	 System.out.println(id);
	 ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 try {
				 employeeService.deleteEmployee(id);
			 }
	 		catch(Exception e) {
	 			e.printStackTrace();
	 			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 		}
	 return responseEntity;
 }
 
 @PutMapping("/update/{id}")
 public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
	 return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
	 
 }
 
 
}
