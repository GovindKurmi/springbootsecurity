package com.security.springbootsecurity.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.security.springbootsecurity.model.Employee;
import com.security.springbootsecurity.model.Login;

public interface EmployeeService {

	public List<Employee> getUser();

	public ResponseEntity<Employee> saveUser(Employee user);

	public void deleteUser(int id);

	public ResponseEntity<Employee> getbyid(int id);

	public ResponseEntity<Employee> updateEmployee(int id, Employee employee);

	public void saveAllUser(List<Employee> employee);

	public List<Login> userLogin(Login login);

}
