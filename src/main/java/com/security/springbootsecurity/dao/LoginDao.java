package com.security.springbootsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.springbootsecurity.model.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer> {

}
