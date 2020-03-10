package com.projetoAvancado.apiRestaurante.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cardapio")
public class Cardapio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	@Column
	private String titulo;
	@Column
	private String descricao;
	@Column
	private double valor;	

	@OneToMany
	private List<ItemPedido> item;
	
	public Cardapio() {
		
	}
	
	public Cardapio(Long id, String titulo, String descricao, double valor) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
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

	public List<ItemPedido> getItem() {
		return item;
	}

	public void setItem(List<ItemPedido> item) {
		this.item = item;
	}
	
	
}
