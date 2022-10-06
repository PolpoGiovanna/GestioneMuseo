package com.example.demo.dto.request.opera;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ModificaOperaDto {
	private long idOpera;
	private String nome;
	private LocalDate data;
	private String dimensioni;
	private String codiceUnivoco;
	private long idPosizione;
	private long idTipoOpera;
	private long idArtista;
	
	public ModificaOperaDto() {
		super();
	}

	public long getIdOpera() {
		return idOpera;
	}

	public void setIdOpera(long idOpera) {
		this.idOpera = idOpera;
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

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

	public long getIdPosizione() {
		return idPosizione;
	}

	public void setIdPosizione(long idPosizione) {
		this.idPosizione = idPosizione;
	}

	public long getIdTipoOpera() {
		return idTipoOpera;
	}

	public void setIdTipoOpera(long idTipoOpera) {
		this.idTipoOpera = idTipoOpera;
	}

	public long getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(long idArtista) {
		this.idArtista = idArtista;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return idOpera != 0 && !nome.isEmpty() && data !=null && !dimensioni.isEmpty() &&
				!codiceUnivoco.isEmpty() && idPosizione != 0 && idTipoOpera != 0 && idArtista != 0;
	}
}
