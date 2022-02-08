package com.security.springbootsecurity.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.security.springbootsecurity.dao.EmployeeDao;
import com.security.springbootsecurity.dao.LoginDao;
import com.security.springbootsecurity.model.Employee;
import com.security.springbootsecurity.model.Login;
import com.security.springbootsecurity.utility.ResourceNotFoundException;

@Service
public class UserServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao userDao;
	@Autowired
	private LoginDao loginDao;

	@Override
	public List<Employee> getUser() {
		List<Employee> user = (List<Employee>) userDao.findAll();
		Collections.sort(user, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
		return user;
	}

	@Override
	public ResponseEntity<Employee> saveUser(Employee user) {
		user.setFirstName(setName(user.getFirstName()));
		return ResponseEntity.ok(userDao.save(user));
	}

	private String setName(String firstName) {
		String s = firstName.substring(0, 1);
		return s.toUpperCase().concat(firstName.substring(1));
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteById(id);
	}

	@Override
	public ResponseEntity<Employee> getbyid(int id) {
		Employee employee = userDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not exit with id" + id));
		return ResponseEntity.ok(employee);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(int id, Employee employee) {
		employee.setFirstName(setName(employee.getFirstName()));

		userDao.save(employee);
		return ResponseEntity.ok(employee);
	}

	@Override
	public void saveAllUser(List<Employee> employee) {
		userDao.saveAll(employee);
	}

	@Override
	public List<Login> userLogin(Login login) {
		return loginDao.findAll();
	}

}
