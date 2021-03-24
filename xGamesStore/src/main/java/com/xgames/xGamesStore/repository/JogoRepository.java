package com.xgames.xGamesStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xgames.xGamesStore.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{
	public List<Jogo> findAllByNomeContainingIgnoreCase(String nome);
}
