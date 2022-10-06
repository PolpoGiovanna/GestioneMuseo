package com.example.demo.dto.response.artista;


public class InsertArtResponseDto {
	private long id;
	
	public InsertArtResponseDto() {
		super();
	}

	public InsertArtResponseDto(long id) {
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
