package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nome;
	private String cognome;
	@Column(nullable = false)
	private LocalDate dataNascita;
	@Column(nullable = false)
	private LocalDate dataMorte;
	@Column(nullable = false)
	private boolean eliminato;
	public Artista() {
		
	}

	public Artista(String nome, String cognome, LocalDate dataNascita, LocalDate dataMorte) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
	}

	public Artista(String nome, String cognome, LocalDate dataNascita, LocalDate dataMorte, boolean eliminato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
		this.eliminato = eliminato;
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

	public boolean isEliminato() {
		return eliminato;
	}

	public void setEliminato(boolean eliminato) {
		this.eliminato = eliminato;
	}
}
