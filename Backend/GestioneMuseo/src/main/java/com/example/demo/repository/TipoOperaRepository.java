package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.TipoOpera;

public interface TipoOperaRepository extends JpaRepository<TipoOpera, Long>{
	@Query(" select t from TipoOpera t where t.id=:id ")
	public TipoOpera SelectFromId(long id);
	@Query(" select t from TipoOpera t where t.eliminato=false ")
	public List<TipoOpera> listaTipoOpera();
}
