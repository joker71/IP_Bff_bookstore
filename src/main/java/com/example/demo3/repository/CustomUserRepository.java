package com.example.demo3.repository;


import com.example.demo3.entity.User;

public interface CustomUserRepository {

	User findByUserName(String userName);
	
	User findByEmail(String email);
	
}
