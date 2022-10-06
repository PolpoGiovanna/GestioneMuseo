package com.example.demo.dto.response.tipoOpera;

import java.util.List;

import com.example.demo.model.TipoOpera;

public class ListaTipoResponseDto {
	private List<TipoOpera> listaTipoOPera;

	public ListaTipoResponseDto() {
		super();
	}

	public ListaTipoResponseDto(List<TipoOpera> listaTipoOPera) {
		super();
		this.listaTipoOPera = listaTipoOPera;
	}

	public List<TipoOpera> getListaTipoOPera() {
		return listaTipoOPera;
	}

	public void setListaTipoOPera(List<TipoOpera> listaTipoOPera) {
		this.listaTipoOPera = listaTipoOPera;
	}
}
