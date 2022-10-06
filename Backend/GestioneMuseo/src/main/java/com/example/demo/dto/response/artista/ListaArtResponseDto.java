package com.example.demo.dto.response.artista;

import java.util.List;

import com.example.demo.model.Artista;

public class ListaArtResponseDto {
	private List<Artista> listaArtista;

	public ListaArtResponseDto() {
		super();
	}

	public ListaArtResponseDto(List<Artista> listaArtista) {
		super();
		this.listaArtista = listaArtista;
	}

	public List<Artista> getListaArtista() {
		return listaArtista;
	}

	public void setListaArtista(List<Artista> listaArtista) {
		this.listaArtista = listaArtista;
	}
}
