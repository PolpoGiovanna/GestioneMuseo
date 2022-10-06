package com.example.demo.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TipoOpera;
import com.example.demo.repository.TipoOperaRepository;

@Service
public class TipoOperaService {
	@Autowired
	TipoOperaRepository repo;

	public boolean insertTipoOpera(TipoOpera tipo) {
		try {
			tipo = repo.save(tipo);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public TipoOpera SelectFromId(long id) {
		TipoOpera t = repo.findById(id).orElse(null);
		return t;
	}
	
	public boolean modificaTipoOpera(long id, String nome ) {
		try {
			TipoOpera t = SelectFromId(id);
			t.setNome(nome);
			t= repo.save(t);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean eliminaTipoOpera(long id) {
		TipoOpera t = SelectFromId(id);
		try {
			if(t!= null) {
				t.setEliminato(true);
				t = repo.save(t);
				return  true;
			}else {
				return true;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	public List<TipoOpera> listaTipoOpera(){
		List<TipoOpera> lista = repo.listaTipoOpera();
		return lista;
	}
}
