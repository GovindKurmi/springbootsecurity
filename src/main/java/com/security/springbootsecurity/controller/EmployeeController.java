package com.security.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springbootsecurity.model.Employee;
import com.security.springbootsecurity.service.EmployeeService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeService userService;
    
	@GetMapping("/getUser")
	public List<Employee> getUser() {
		List<Employee> user = userService.getUser();
		return user;
	}
	
	@PostMapping("/saveAllUser")
	public void saveAllUser(@RequestBody List<Employee> employee) {
		userService.saveAllUser(employee);
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<Employee> saveUser(@RequestBody Employee employee) {
		return userService.saveUser(employee);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Employee> getbyid(@PathVariable("id") int id) {
		return userService.getbyid(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return userService.updateEmployee(id, employee);
	}

}
