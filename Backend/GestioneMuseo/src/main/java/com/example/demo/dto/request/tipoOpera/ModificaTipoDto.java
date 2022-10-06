package com.example.demo.dto.request.tipoOpera;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ModificaTipoDto {
	private long id;
	private String nome;
	
	public ModificaTipoDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
