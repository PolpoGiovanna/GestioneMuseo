package com.example.demo.servicies;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Artista;
import com.example.demo.model.Opera;
import com.example.demo.model.Posizione;
import com.example.demo.model.TipoOpera;
import com.example.demo.repository.OperaRepository;

@Service
public class OperaService {
	@Autowired
	OperaRepository repo;
	
	//insert
	public boolean aggiungiOpera(Opera o) {
		try {
			o = repo.save(o);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public Opera findOperaById(long id) {
		return repo.findById(id).orElse(null);
	}

	//delete
	public boolean elimanaOpera(long idOpera) {
		Opera o = repo.SelectOperaFromId(idOpera);
		if(o != null) {
			o.setEliminato(true);
			o = repo.save(o);
			return true;
		}else {
			return false;
		}
	}

	//update
	public boolean modificaOpera(long idOpera, String nome, LocalDate data, String dimensioni,
								 TipoOpera tipo, String codiceUnivoco, Posizione posizione, Artista artista) {
		Opera o = repo.SelectOperaFromId(idOpera);
		if(o != null) {
			o.setNome(nome);
			o.setData(data);
			o.setDimensioni(dimensioni);
			o.setTipo(tipo);
			o.setCodiceUnivoco(codiceUnivoco);
			o.setPosizione(posizione);
			o.setArtista(artista);
			o = repo.save(o);
			return true;
		}else {
			return false;
		}
	}
	
	public List<Opera> listaOpera(){
		List<Opera> lista = repo.listaOpera();
		return lista;
	}
}
