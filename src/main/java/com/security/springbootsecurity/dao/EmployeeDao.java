package com.security.springbootsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.springbootsecurity.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
