package com.example.demo.dto.response.opera;

public class InsertOpeResponseDto {
	private long id;

	public InsertOpeResponseDto() {
		super();
	}

	public InsertOpeResponseDto(long id) {
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
