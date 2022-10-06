package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.utente.LoginDto;
import com.example.demo.dto.request.utente.RegistrazioneDto;
import com.example.demo.dto.response.utente.LoginUtenteResponseDto;
import com.example.demo.dto.response.utente.RegistrazioneUtenteResponseDto;
import com.example.demo.model.Utente;
import com.example.demo.servicies.UtenteService;

@RestController
@CrossOrigin
@RequestMapping("/utente")
public class UtenteController {
	@Autowired
	UtenteService service;
	
	@RequestMapping(method= RequestMethod.POST, path = "/registra")
	public ResponseEntity<RegistrazioneUtenteResponseDto> registrazione(@RequestBody RegistrazioneDto request) {
		if(request.isValid()) {
			Utente u = new Utente(request.getNome(), 
					  			  request.getCognome(),
					  			  request.getEmail(),
					  			  request.getPassword());
			if(service.registraUtente(u)) {
				return ResponseEntity.status(200).build();
			}else {
				return ResponseEntity.status(409).build();
			}
		}else{
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method= RequestMethod.POST, path = "/login")
	public ResponseEntity<LoginUtenteResponseDto> login(@RequestBody LoginDto request) {
		if(request.isValid()) {
			Utente u= service.loginUtente(request.getEmail(), request.getPassword());
			if(u==null) {
				return ResponseEntity.status(409).build();
			}else {
				return ResponseEntity.status(200).body(new LoginUtenteResponseDto(u.getId()));
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
}
