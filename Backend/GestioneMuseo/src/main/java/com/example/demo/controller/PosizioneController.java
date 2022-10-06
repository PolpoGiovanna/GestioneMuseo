package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.posizione.EliminaPosDto;
import com.example.demo.dto.request.posizione.InsertPosDto;
import com.example.demo.dto.request.posizione.ModificaPosDto;
import com.example.demo.dto.response.artista.EliminaArtResponeseDto;
import com.example.demo.dto.response.posizione.InsertPosResponseDto;
import com.example.demo.dto.response.posizione.ListaPosResponseDto;
import com.example.demo.dto.response.posizione.ModificaPosResponseDto;
import com.example.demo.model.Posizione;
import com.example.demo.servicies.PosizioneService;

@RestController
@CrossOrigin
@RequestMapping("/posizione")
public class PosizioneController {
	@Autowired
	PosizioneService service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/aggiungi")
	public ResponseEntity<InsertPosResponseDto> inserisciPosizione(@RequestBody InsertPosDto request){
		if(request.isValid()) {
			Posizione p = new Posizione(request.getLuogo());
			if(service.aggiungiLuogo(p)) {
				return ResponseEntity.status(200).body(new InsertPosResponseDto(p.getId()));
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/elimina")
	public ResponseEntity<EliminaArtResponeseDto> eliminaPosizione(@RequestBody EliminaPosDto request) {
		if(service.eliminaLuogo(request.getIdLuogo())) {
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(409).build();
		}
	}
	@RequestMapping(method = RequestMethod.POST, path = "/modifica")
	public ResponseEntity<ModificaPosResponseDto> modificaPosizione(@RequestBody ModificaPosDto request) {
		if(request.idValid()) {
			if(service.modificaLuogo(request.getId(), request.getLuogo())) {
				return ResponseEntity.status(200).build();
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	@RequestMapping(method = RequestMethod.POST, path = "/lista")
	public ResponseEntity<ListaPosResponseDto> listaPosizione(){
		List<Posizione> p = service.listaPosizione();
		return ResponseEntity.status(200).body(new ListaPosResponseDto(p));
	}
}
