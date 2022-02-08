package com.security.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springbootsecurity.model.Login;
import com.security.springbootsecurity.service.EmployeeService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/login")
	public void login(@RequestBody Login login) {
		List<Login> log = employeeService.userLogin(login);
		if (log.get(0).getPassword().equals(login.getPassword())) {
			System.out.println("login");
		} else {
			System.out.println("noot");
		}
	}
}
