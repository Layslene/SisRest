package com.projetoAvancado.apiRestaurante.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAvancado.apiRestaurante.DTO.NovoPedidoDTO;
import com.projetoAvancado.apiRestaurante.Services.PedidoService;
import com.projetoAvancado.apiRestaurante.models.Pedido;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	@ApiOperation(value="Retorna todos os pedidos")
	public List <Pedido> getPedidos() {
		return pedidoService.getPedidos();
	}

	@GetMapping("/{id}")
	@ApiOperation(value="Retorna um pedido específico")
	public Optional<Pedido> getPedidoById (@PathVariable Long id) {
		return pedidoService.findById(id);
	}
	
	@PostMapping
	@ApiOperation(value="Adiciona um pedido")
	public void addItem(@RequestBody NovoPedidoDTO itemDTO) {
		Pedido item = pedidoService.fromDTO(itemDTO);
		pedidoService.addPedido(item);
	}
	
	@PutMapping(value= "/{id}")
	@ApiOperation(value="Altera um pedido específico")
	public void update(@PathVariable Long id, @RequestBody Pedido pedido) {
		pedidoService.update(id, pedido);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta um pedido específico")
	public void delete(@PathVariable("id") Long id) {
		pedidoService.delete(id);
	}
}
