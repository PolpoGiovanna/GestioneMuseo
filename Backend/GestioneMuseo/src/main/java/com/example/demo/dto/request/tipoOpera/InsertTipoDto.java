package com.example.demo.dto.request.tipoOpera;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InsertTipoDto {
	private String nome;

	public InsertTipoDto() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return nome != null && !nome.isEmpty();
	}
}
