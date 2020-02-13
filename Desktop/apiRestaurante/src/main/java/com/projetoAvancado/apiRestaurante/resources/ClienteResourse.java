package com.projetoAvancado.apiRestaurante.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAvancado.apiRestaurante.DTO.ExibirClienteDTO;
import com.projetoAvancado.apiRestaurante.Services.ClienteService;
import com.projetoAvancado.apiRestaurante.models.Cliente;

@RestController
@RequestMapping("/api/clientes")

public class ClienteResourse {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public void addCliente(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
	}
	
	@PutMapping(value= "/{id}")
	public void attProprietario(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.attCliente(id, cliente);
	}
	
	@GetMapping(value = "/{id}")
	public ExibirClienteDTO getById(@PathVariable("id") Long id){
		Optional<Cliente> obj = clienteService.getById(id);
		ExibirClienteDTO objDTO = new ExibirClienteDTO(obj.get());
		return objDTO;
	}
	
	@GetMapping
	public List<ExibirClienteDTO> getProdutos() {
		List<Cliente> lista = clienteService.findAll();
		List<ExibirClienteDTO> listaDTO = lista.stream().map(obj -> new ExibirClienteDTO(obj))
				.collect(Collectors.toList());
		return listaDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}
}


