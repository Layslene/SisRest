package com.projetoAvancado.apiRestaurante.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAvancado.apiRestaurante.DTO.EditarClienteDTO;
import com.projetoAvancado.apiRestaurante.DTO.NovoClienteDTO;
import com.projetoAvancado.apiRestaurante.models.Cliente;
import com.projetoAvancado.apiRestaurante.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> getById(Long id) {
		return clienteRepository.findById(id);
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public void delete(Long id) {
		Optional<Cliente> cliente = getById(id);
		if(cliente.isPresent()) {
			clienteRepository.deleteById(id);
		}
	}

	public void attCliente(Long id, Cliente cliente) {
		Optional<Cliente> clienteOptional = getById(id);
		if (clienteOptional.isPresent()) {
			Cliente clienteDb = clienteOptional.get();
			clienteDb.setNome(cliente.getNome());
			clienteDb.setEmail(cliente.getEmail());
			clienteDb.setSenha(cliente.getSenha());
			clienteRepository.save(clienteDb);
		} else {
			throw new RuntimeException("Não foi possível atualizar o Proprietario");
		}	
	}
	
	public Cliente fromDTO(NovoClienteDTO cardDTO) {
		Cliente card = new Cliente(null, cardDTO.getNome(), cardDTO.getEmail());
		return card;
	}
	
	public Cliente fromDTO(EditarClienteDTO cardDTO) {
		Cliente card = new Cliente(null, cardDTO.getNome(), cardDTO.getEmail());
		return card;
	
	}

}
