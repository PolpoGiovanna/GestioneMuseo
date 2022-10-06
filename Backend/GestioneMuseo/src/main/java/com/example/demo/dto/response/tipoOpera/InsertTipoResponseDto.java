package com.example.demo.dto.response.tipoOpera;

public class InsertTipoResponseDto {
	private long id;

	public InsertTipoResponseDto() {
		super();
	}

	public InsertTipoResponseDto(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
