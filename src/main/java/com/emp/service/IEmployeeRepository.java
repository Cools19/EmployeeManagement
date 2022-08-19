package com.emp.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer>{

	//public List<Employee> deleteAllEmployees();

}
