package com.projetoAvancado.apiRestaurante.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tbl_itemPedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Cardapio cardapio;
		
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pedido pedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	private int quantidade;

	public ItemPedido() {
		
	}
	
	public ItemPedido(Long id, Cardapio cardapio, Cliente cliente, int quantidade) {
		this.id = id;
		this.cardapio = cardapio;
		this.cliente = cliente;
		this.quantidade = quantidade;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Cardapio getCardapio() {
		return cardapio;
	}


	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
