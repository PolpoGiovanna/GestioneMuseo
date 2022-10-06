package com.example.demo.dto.response.posizione;

public class InsertPosResponseDto {
	private long id;

	public InsertPosResponseDto() {
		super();
	}
	
	public InsertPosResponseDto(long id) {
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
