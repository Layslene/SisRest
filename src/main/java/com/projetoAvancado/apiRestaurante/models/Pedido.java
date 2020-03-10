package com.projetoAvancado.apiRestaurante.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String data;
	@Column
	private String status;
	
	@OneToMany
	private List<ItemPedido> itens;
	
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	@JoinColumn(nullable = false)
	private Cardapio cardapio;
	
	public Pedido() {
		
	}

	public Pedido(Long id, List<ItemPedido> itens) {
		this.id = id;
		this.itens = itens;
		
	}
	
	public Pedido(Long id) {
		this.id = id;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
