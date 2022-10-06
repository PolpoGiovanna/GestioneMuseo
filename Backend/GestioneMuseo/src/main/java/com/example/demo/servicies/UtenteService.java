package com.example.demo.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	UtenteRepository repo;
	
	private static String REGEX_PASSWORD = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
	private static String REGEX_EMAIL ="([A-Za-z0-9!#-'*+\\-/=?^_`{-~\\xA0-\\x{10FFFF}]+(?:\\.[A-Za-z0-9!#-'*+\\-/=?^_`{-~\\xA0-\\x{10FFFF}])|(?:[ !#-\\[\\]-~\\xA0-\\x{10FFFF}]|\\\\[ -~])*)@((?:[A-Za-z0-9](?:[A-Za-z0-9\\-]*[A-Za-z0-9])?|[\\x00-\\x{10FFFF}]*[\\x80-\\x{10FFFF}]+[\\x00-\\x{10FFFF}]*)(?:\\.(?:[A-Za-z0-9](?:[A-Za-z0-9\\-]*[A-Za-z0-9])?|[\\x00-\\x{10FFFF}]*[\\x80-\\x{10FFFF}]+[\\x00-\\x{10FFFF}]*))*)";
	
	public boolean registraUtente(Utente u) {
		try {
			if(u.getPassword().matches(REGEX_PASSWORD) || u.getEmail().matches(REGEX_EMAIL)) {
				u = repo.save(u);
				return u!=null;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public Utente loginUtente(String email, String password) {
		 Utente u = repo.login(email, password);
		 return u;
	}
	
	public Utente findById(long id) {
		return repo.findById(id).orElse(null);
	}
}
