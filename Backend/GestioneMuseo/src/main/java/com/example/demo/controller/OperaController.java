package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.opera.EliminaOperaDto;
import com.example.demo.dto.request.opera.InsertOperaDto;
import com.example.demo.dto.request.opera.ModificaOperaDto;
import com.example.demo.dto.response.opera.EliminaOpeResponseDto;
import com.example.demo.dto.response.opera.InsertOpeResponseDto;
import com.example.demo.dto.response.opera.ListaOpeResponseDto;
import com.example.demo.dto.response.opera.ModificaOpeResponseDto;
import com.example.demo.model.Artista;
import com.example.demo.model.Opera;
import com.example.demo.model.Posizione;
import com.example.demo.model.TipoOpera;
import com.example.demo.servicies.ArtistaService;
import com.example.demo.servicies.OperaService;
import com.example.demo.servicies.PosizioneService;
import com.example.demo.servicies.TipoOperaService;

@RestController
@CrossOrigin
@RequestMapping("/opera")
public class OperaController {
	@Autowired
	OperaService serviceOpera;
	@Autowired
	ArtistaService serviceArtista;
	@Autowired
	PosizioneService servicePosizione;
	@Autowired
	TipoOperaService serviceTipoOpera;
	
	@RequestMapping(method = RequestMethod.POST, path = "/aggiungi")
	public ResponseEntity<InsertOpeResponseDto> inserisciOpera(@RequestBody InsertOperaDto request) {
		if(request.isValid()) {
			Artista a = serviceArtista.SelectFromId(request.getIdArtista());
			Posizione p = servicePosizione.SelectPosizioneFromId(request.getIdPosizione());
			TipoOpera t = serviceTipoOpera.SelectFromId(request.getIdTipoOpera());
			
			Opera o = new Opera(request.getNome(), request.getData(), 
								request.getDimensioni(), request.getCodiceUnivoco(), p, t, a);
			
			if(serviceOpera.aggiungiOpera(o)) {
				return ResponseEntity.status(200).body(new InsertOpeResponseDto(o.getId()));
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/modifica")
	public ResponseEntity<ModificaOpeResponseDto> modificaOpera(@RequestBody ModificaOperaDto request) {
		if(request.isValid()) {
			Artista a = serviceArtista.SelectFromId(request.getIdArtista());
			Posizione p = servicePosizione.SelectPosizioneFromId(request.getIdPosizione());
			TipoOpera t = serviceTipoOpera.SelectFromId(request.getIdTipoOpera());
			
			if(serviceOpera.modificaOpera(request.getIdOpera(), request.getNome(), 
						request.getData(),request.getDimensioni(), t , request.getCodiceUnivoco(),p , a)) {
				return ResponseEntity.status(200).build();
			}else {
				return ResponseEntity.status(409).build();
			}
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/elimina")
	public ResponseEntity<EliminaOpeResponseDto> eliminaOPera(@RequestBody EliminaOperaDto request){
		if(serviceOpera.elimanaOpera(request.getIdOpera())) {
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(409).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/lista")
	public ResponseEntity<ListaOpeResponseDto> listaOpera(){
		List<Opera> o = serviceOpera.listaOpera();
		return ResponseEntity.status(200).body(new ListaOpeResponseDto(o));
	}
}
