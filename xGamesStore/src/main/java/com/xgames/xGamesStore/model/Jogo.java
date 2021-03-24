package com.xgames.xGamesStore.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_jogo")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String desenvolvedora;
	
	@NotNull
	private long qtdEstoque;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	private BigDecimal preco;
	
	@OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("jogo")
	private List<Plataforma> plataforma;
	
	@ManyToOne
	@JsonIgnoreProperties("jogo")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<Plataforma> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(List<Plataforma> plataforma) {
		this.plataforma = plataforma;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
