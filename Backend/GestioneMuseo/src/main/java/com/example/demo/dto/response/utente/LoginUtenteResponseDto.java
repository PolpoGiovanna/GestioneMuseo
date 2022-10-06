package com.example.demo.dto.response.utente;

public class LoginUtenteResponseDto {

	private long id;

	public LoginUtenteResponseDto() {
		super();
	}
	
	public LoginUtenteResponseDto(long id) {
		super();
		this.id = id;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
