package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoOpera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique=true)
	private String nome;
	@Column(nullable = false)
	private boolean eliminato;
	
	public TipoOpera() {
		
	}

	public TipoOpera(String nome) {
		this.nome = nome;
	}
	
	public TipoOpera(String nome, boolean eliminato) {
		super();
		this.nome = nome;
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

	public boolean isEliminato() {
		return eliminato;
	}

	public void setEliminato(boolean eliminato) {
		this.eliminato = eliminato;
	}
	
}
