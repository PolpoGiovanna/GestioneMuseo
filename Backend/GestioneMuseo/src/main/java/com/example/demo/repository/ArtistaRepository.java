package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{
	@Query("select a from Artista a where a.eliminato=false")
	public List<Artista> listaArtista();
	@Query(" select a from Artista a where a.id=:id ")
	public Artista SelectFromId(long id);
}
