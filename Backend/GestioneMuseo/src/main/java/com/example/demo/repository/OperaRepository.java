package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Opera;

public interface OperaRepository extends JpaRepository<Opera, Long> {
	@Query("select o from Opera o where o.id=:idOpera")
	public Opera SelectOperaFromId(long idOpera);
	@Query(" select o from Opera o where o.eliminato=false ")
	public List<Opera> listaOpera();
}
