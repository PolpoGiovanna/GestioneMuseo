package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Posizione;

public interface PosizioneRepository extends JpaRepository<Posizione, Long> {
	@Query(" select p from Posizione p where p.id=:id ")
	public Posizione SelectFromId(long id);
	@Query(" select p from Posizione p where p.eliminato=false ")
	public List<Posizione> listaPosizione();
}
