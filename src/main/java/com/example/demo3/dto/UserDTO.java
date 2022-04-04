package com.example.demo3.dto;

//import javax.validation.constraints.NotNull;

import com.sun.istack.NotNull;

public class UserDTO {

	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String mobile;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
