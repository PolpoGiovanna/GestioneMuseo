package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginDto {
	private String email, password;

	public LoginDto() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return email != null && password != null && !email.isEmpty() && !password.isEmpty();
	}
}
