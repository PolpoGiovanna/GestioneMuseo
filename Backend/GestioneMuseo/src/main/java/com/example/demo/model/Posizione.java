package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posizione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique=true)
	private String luogo;
	@Column(nullable = false)
	private boolean eliminato;
	
	public Posizione() {
		super();
	}

	public Posizione(String luogo, boolean eliminato) {
		super();
		this.luogo = luogo;
		this.eliminato = eliminato;
	}

	public Posizione(String luogo) {
		super();
		this.luogo = luogo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public boolean isEliminato() {
		return eliminato;
	}

	public void setEliminato(boolean eliminato) {
		this.eliminato = eliminato;
	}
}
