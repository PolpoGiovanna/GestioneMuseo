package com.example.demo.servicies;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Artista;
import com.example.demo.repository.ArtistaRepository;


@Service
public class ArtistaService {
	@Autowired
	ArtistaRepository repo;
	
	public boolean insertArtista(Artista artista) {
		try {
			if(artista.getDataNascita().isBefore(artista.getDataMorte())) {
				artista = repo.save(artista);
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	public Artista SelectFromId(long id) {
		Artista a = repo.findById(id).orElse(null);
		return a;
	}
	
	public boolean modificaArtista(long id, String nome, String cognome, LocalDate dataNascita, LocalDate datMorte) {
		try {
			Artista a = SelectFromId(id);
			if(a.isEliminato()== false && a != null && dataNascita.isBefore(datMorte)) {
				a.setNome(nome);
				a.setCognome(cognome);
				a.setDataNascita(dataNascita);
				a.setDataMorte(datMorte);
				a = repo.save(a);
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean eliminaArtista(long id) {
		Artista a = SelectFromId(id);
		try {
			if(a != null) {
				a.setEliminato(true);
				a = repo.save(a);
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	public List<Artista> listaArtista(){
		List<Artista> lista = repo.listaArtista();
		return lista;
	}
}
