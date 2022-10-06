package com.example.demo.dto.response.posizione;

import java.util.List;

import com.example.demo.model.Posizione;

public class ListaPosResponseDto {
	private List<Posizione> listaPosizione;

	public ListaPosResponseDto() {
		super();
	}

	public ListaPosResponseDto(List<Posizione> listaPosizione) {
		super();
		this.listaPosizione = listaPosizione;
	}

	public List<Posizione> getListaPosizione() {
		return listaPosizione;
	}

	public void setListaPosizione(List<Posizione> listaPosizione) {
		this.listaPosizione = listaPosizione;
	}
}
