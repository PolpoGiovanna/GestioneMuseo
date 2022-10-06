package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegistrazioneDto {
	private String nome, cognome, email, password;
	
	public RegistrazioneDto() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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
		return nome!=null && cognome!=null && email!=null && password!=null
				&& !nome.isBlank() && !nome.isEmpty()
				&& !cognome.isBlank() && !cognome.isEmpty();
	}
}
