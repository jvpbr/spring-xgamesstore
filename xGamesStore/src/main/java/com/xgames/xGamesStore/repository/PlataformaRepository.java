package com.xgames.xGamesStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xgames.xGamesStore.model.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long>{
	public List<Plataforma> findAllByNomeContainingIgnoreCase(String nome);
	
	//public List<Plataforma> findAllByMarcaContainingIgnoreCase(String Marca);
	
	public List<Plataforma> findAllByCategoriaContainingIgnoreCase(String categoria);
}
