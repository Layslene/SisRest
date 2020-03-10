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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/clientes")

public class ClienteResourse {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ApiOperation(value="Salva um cliente no banco")
	public void addCliente(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
	}
	
	@PutMapping(value= "/{id}")
	@ApiOperation(value="Altera as informações de um cliente")
	public void attProprietario(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.attCliente(id, cliente);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value="Retorna um cliente especifico")
	public ExibirClienteDTO getById(@PathVariable("id") Long id){
		Optional<Cliente> obj = clienteService.getById(id);
		ExibirClienteDTO objDTO = new ExibirClienteDTO(obj.get());
		return objDTO;
	}
	
	@GetMapping
	@ApiOperation(value="Retorna todos os clientes")
	public List<ExibirClienteDTO> getProdutos() {
		List<Cliente> lista = clienteService.findAll();
		List<ExibirClienteDTO> listaDTO = lista.stream().map(obj -> new ExibirClienteDTO(obj))
				.collect(Collectors.toList());
		return listaDTO;
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta um cliente específico")
	public void delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}
}


