package com.projetoAvancado.apiRestaurante.DTO;

import java.util.List;

import com.projetoAvancado.apiRestaurante.models.Cardapio;

public class NovoPedidoDTO {
	
	Cardapio cardapio;
	private Long id;
	private List<Long> itemId;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Long> getItemId() {
		return itemId;
	}
	public void setItemId(List<Long> itemId) {
		this.itemId = itemId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	public Long getCardapioId() {
		
		return cardapio.getId();
	}
	
	
	
}