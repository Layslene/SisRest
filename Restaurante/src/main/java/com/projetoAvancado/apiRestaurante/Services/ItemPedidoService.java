package com.projetoAvancado.apiRestaurante.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAvancado.apiRestaurante.DTO.NovoItemPedidoDTO;
import com.projetoAvancado.apiRestaurante.models.ItemPedido;
import com.projetoAvancado.apiRestaurante.repository.CardapioRepository;
import com.projetoAvancado.apiRestaurante.repository.ClienteRepository;
import com.projetoAvancado.apiRestaurante.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRep;
	@Autowired
	CardapioRepository cardRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	public void save(ItemPedido cardapio) {
		itemPedidoRep.save(cardapio);
	}

	public ItemPedido fromDTO(NovoItemPedidoDTO itemDTO) {
		ItemPedido item = new ItemPedido(null, cardRepository.findById(itemDTO.getCardapioId()).get(), 
				clienteRepository.findById(itemDTO.getClienteId()).get(),
				itemDTO.getQuantidade());
		return item;
	}

	public List<ItemPedido> findAll() {
		return itemPedidoRep.findAll();
	}

	public Optional<ItemPedido> getById(Long id) {
		return itemPedidoRep.findById(id);
	}

	public void delete(Long id) {
		itemPedidoRep.deleteById(id);
		
	}
	
	
}
