package com.xgames.xGamesStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xgames.xGamesStore.model.Plataforma;
import com.xgames.xGamesStore.repository.PlataformaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/plataforma")
public class PlataformaController {

	@Autowired
	private PlataformaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Plataforma>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plataforma> getById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Plataforma>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	/*
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<Plataforma>> getByMarca(@PathVariable String marca){
		return ResponseEntity.ok(repository.findAllByMarcaContainingIgnoreCase(marca));
	}
	*/
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Plataforma>> getByCategoria(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PostMapping
	public ResponseEntity<Plataforma> post (@RequestBody Plataforma plataforma){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(plataforma));
	}
	
	@PutMapping
	public ResponseEntity<Plataforma> put (@RequestBody Plataforma plataforma){
		return ResponseEntity.ok(repository.save(plataforma));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
