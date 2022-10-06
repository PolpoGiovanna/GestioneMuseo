package com.example.demo.dto.request.posizione;

public class ModificaPosDto {
	private long id;
	private String luogo;
	public ModificaPosDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public boolean idValid() {
		return !luogo.isEmpty();
	}
}
