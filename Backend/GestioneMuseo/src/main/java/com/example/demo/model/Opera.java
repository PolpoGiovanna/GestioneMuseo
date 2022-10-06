package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private LocalDate data;
	@Column(nullable = false)
	private String dimensioni ;
	@Column(nullable = false)
	private boolean eliminato;
	@Column(nullable = false, unique=true)
	private String codiceUnivoco;
	
	@ManyToOne
	@JoinColumn(name = "id_posizione", nullable = false, updatable = false)
	private Posizione posizione;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo", nullable = false, updatable = false)
	private TipoOpera tipo;
	
	@ManyToOne
	@JoinColumn(name= "id_artista", nullable = false, updatable = false)
	private Artista artista;
	
	public Opera() {
		
	}

	public Opera(String nome, LocalDate data, String dimensioni,TipoOpera tipo, String codiceUnivoco, Posizione posizione, boolean eliminato, Artista artista) {
		this.nome = nome;
		this.data = data;
		this.dimensioni = dimensioni;
		this.tipo = tipo;
		this.codiceUnivoco = codiceUnivoco;
		this.posizione = posizione;
		this.eliminato = eliminato;
		this.artista = artista;
	}

	public Opera(String nome, LocalDate data, String dimensioni, String codiceUnivoco, Posizione posizione,
			TipoOpera tipo, Artista artista) {
		super();
		this.nome = nome;
		this.data = data;
		this.dimensioni = dimensioni;
		this.codiceUnivoco = codiceUnivoco;
		this.posizione = posizione;
		this.tipo = tipo;
		this.artista = artista;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoOpera getTipo() {
		return tipo;
	}

	public void setTipo(TipoOpera tipo) {
		this.tipo = tipo;
	}

	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public Posizione getPosizione() {
		return posizione;
	}

	public void setPosizione(Posizione posizione) {
		this.posizione = posizione;
	}

	public boolean isEliminato() {
		return eliminato;
	}

	public void setEliminato(boolean eliminato) {
		this.eliminato = eliminato;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}
