package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.tipoOpera.EliminaTipoDto;
import com.example.demo.dto.request.tipoOpera.InsertTipoDto;
import com.example.demo.dto.request.tipoOpera.ModificaTipoDto;
import com.example.demo.dto.response.posizione.EliminaPosResponseDto;
import com.example.demo.dto.response.tipoOpera.InsertTipoResponseDto;
import com.example.demo.dto.response.tipoOpera.ListaTipoResponseDto;
import com.example.demo.dto.response.tipoOpera.ModificaTipoResponseDto;
import com.example.demo.model.TipoOpera;
import com.example.demo.servicies.TipoOperaService;

@RestController
@CrossOrigin
@RequestMapping("/tipo")
public class TipoOperaController {
	@Autowired
	TipoOperaService service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/inserisci")
	public ResponseEntity<InsertTipoResponseDto> inserisciTipoOpera(@RequestBody InsertTipoDto request) {
		if(request.isValid()) {
			TipoOpera t = new TipoOpera(request.getNome());
			if(service.insertTipoOpera(t)) {
				return ResponseEntity.status(200).body(new InsertTipoResponseDto(t.getId()));
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/modifica")
	public ResponseEntity<ModificaTipoResponseDto> modificaTipoOpera(@RequestBody ModificaTipoDto request) {
		if(request.isValid()) {
			if(service.modificaTipoOpera(request.getId(), request.getNome())) {
				return ResponseEntity.status(200).build();
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/elimina")
	public ResponseEntity<EliminaPosResponseDto> eliminaTipoOpera(@RequestBody EliminaTipoDto request) {
		if(service.eliminaTipoOpera(request.getId())) {
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(409).build();
		}
	}
	@RequestMapping(method = RequestMethod.POST, path = "/lista")
	public ResponseEntity<ListaTipoResponseDto> listaTipoOpera(){
		 List<TipoOpera> t = service.listaTipoOpera();
		return ResponseEntity.status(200).body(new ListaTipoResponseDto(t));
	}
}
