package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.artista.EliminaArtDto;
import com.example.demo.dto.request.artista.InsertArtDto;
import com.example.demo.dto.request.artista.ModificaArtDto;
import com.example.demo.dto.response.artista.EliminaArtResponeseDto;
import com.example.demo.dto.response.artista.InsertArtResponseDto;
import com.example.demo.dto.response.artista.ListaArtResponseDto;
import com.example.demo.dto.response.artista.ModificaArtResponseDto;
import com.example.demo.model.Artista;
import com.example.demo.servicies.ArtistaService;

@RestController
@CrossOrigin
@RequestMapping("/artista")
public class ArtistaController {
	@Autowired
	ArtistaService service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/inserisci")
	public ResponseEntity<InsertArtResponseDto> InserisciArtista(@RequestBody InsertArtDto request) {
		if(request.isValid()) {
			Artista a = new Artista(request.getNome(),
									request.getCognome(),
									request.getDataNascita(),
									request.getDataMorte());
			if(service.insertArtista(a)) {
				return ResponseEntity.status(200).body(new InsertArtResponseDto(a.getId()));
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/modifica")
	public ResponseEntity<ModificaArtResponseDto> modificaArtista(@RequestBody ModificaArtDto request) {
		if(request.isValid()) {
			if(service.modificaArtista( request.getId(), request.getNome(), request.getCognome(), request.getDataNascita(), request.getDataMorte())) {
				return ResponseEntity.status(200).build();
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/elimina")
	public ResponseEntity<EliminaArtResponeseDto> eliminaArtista(@RequestBody EliminaArtDto request) {
		if(service.eliminaArtista(request.getId())) {
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(409).build();
		}
	}
	@RequestMapping(method = RequestMethod.POST, path = "/lista")
	public ResponseEntity<ListaArtResponseDto> listaArtista(){
		List<Artista> a = service.listaArtista();
		return ResponseEntity.status(200).body(new ListaArtResponseDto(a));
	}
}
