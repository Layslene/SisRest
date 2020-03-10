package com.projetoAvancado.apiRestaurante.DTO;

import com.projetoAvancado.apiRestaurante.models.Cardapio;

public class ExibirCardapioDTO {
	
	private Long id;
	private String titulo;
	private String descricao;
	private double valor;
	
	
	
	public ExibirCardapioDTO() {
		
	}
	
	public ExibirCardapioDTO(Cardapio card) {
		this.id = card.getId();
		this.titulo = card.getTitulo();
		this.descricao = card.getDescricao();
		this.valor = card.getValor();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	


}
