package com.example.demo.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Posizione;
import com.example.demo.repository.PosizioneRepository;
import com.example.demo.repository.UtenteRepository;

@Service
public class PosizioneService {
	@Autowired
	PosizioneRepository repo;
	@Autowired
	UtenteRepository repoUtente;
	
	public boolean aggiungiLuogo(Posizione posizione) {
		try {
			posizione = repo.save(posizione);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Posizione SelectPosizioneFromId(long id) {
		Posizione p = repo.findById(id).orElse(null);
		return p;
	}
	
	public boolean modificaLuogo(long idPosizione, String luogo){
		try {
			Posizione p = SelectPosizioneFromId(idPosizione);
			if(p != null) {
				p.setLuogo(luogo);
				p = repo.save(p);
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean eliminaLuogo(long idLuogo) {
		Posizione p = SelectPosizioneFromId(idLuogo);
		try {
			p.setEliminato(true);
			p = repo.save(p);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public List<Posizione> listaPosizione(){
		List<Posizione> lista = repo.listaPosizione();
		return lista;
	}
}
