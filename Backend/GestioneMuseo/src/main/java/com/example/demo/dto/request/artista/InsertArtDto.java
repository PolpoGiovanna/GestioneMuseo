package com.example.demo.dto.request.artista;

import java.time.LocalDate;

public class InsertArtDto {
	private String nome, cognome;
	private LocalDate dataNascita, dataMorte;
	
	public InsertArtDto() {
		
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
	
	public boolean isValid() {
		return nome != null && dataNascita != null && dataMorte !=null && dataNascita !=null &&
				!nome.isEmpty() && !cognome.isEmpty();
	}
}
