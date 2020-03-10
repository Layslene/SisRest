package com.projetoAvancado.apiRestaurante.DTO;

import com.projetoAvancado.apiRestaurante.models.Cliente;

public class EditarClienteDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;

	public EditarClienteDTO(){
		
	}
	
	public EditarClienteDTO(Cliente cliente){
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
