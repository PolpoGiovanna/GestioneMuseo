package com.example.demo.dto.response.opera;

import java.util.List;

import com.example.demo.model.Opera;

public class ListaOpeResponseDto {
	private List<Opera> listaOpera;

	public ListaOpeResponseDto() {
		super();
	}

	public ListaOpeResponseDto(List<Opera> listaOpera) {
		super();
		this.listaOpera = listaOpera;
	}

	public List<Opera> getListaOpera() {
		return listaOpera;
	}

	public void setListaOpera(List<Opera> listaOpera) {
		this.listaOpera = listaOpera;
	}
}
