package com.projetoAvancado.apiRestaurante.DTO;

import com.projetoAvancado.apiRestaurante.models.ItemPedido;

public class EditarPedidoDTO {
	
	private Long id;
	private int quantidade;
	
	private Long cardapioId;
	private Long clienteId;
	
	public EditarPedidoDTO (ItemPedido obj) {
		this.id = obj.getId();
		this.quantidade = obj.getQuantidade();
		this.cardapioId = obj.getCardapio().getId();
		this.clienteId = obj.getCardapio().getId();
	}
	
	public EditarPedidoDTO(Long id, int quantidade, Long clienteId, Long cardapioId) {
		this.id = id;
		this.quantidade = quantidade;
		this.clienteId = clienteId;
		this.cardapioId = cardapioId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getCardapioId() {
		return cardapioId;
	}
	public void setCardapioId(Long cardapioId) {
		this.cardapioId = cardapioId;
	}
	
}