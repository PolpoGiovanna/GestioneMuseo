package com.example.demo.dto.request.artista;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ModificaArtDto {
	private long id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private LocalDate dataMorte;
	
	public ModificaArtDto() {
		super();
	}

	public long getId() {
		return id;
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDate getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(LocalDate dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return nome != null && dataNascita != null && 
				dataMorte != null && !nome.isEmpty();
	}
}
