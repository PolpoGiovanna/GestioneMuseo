package com.example.demo.dto.request.posizione;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InsertPosDto {
	private String luogo;

	public InsertPosDto() {
		super();
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	@JsonIgnore
	public boolean isValid() {
		if(luogo != null) {
			return true;
		}else {
			return false;
		}
	}

}
