package com.projetoAvancado.apiRestaurante.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projetoAvancado.apiRestaurante.DTO.NovoClienteDTO;


@Entity
@Table(name="tbl_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String senha;
	
	
	@OneToMany
	private List<ItemPedido> itens;
	
	
	public Cliente() {}
	
	public Cliente(Long id, String nome, String email) {
		this.id = id;
		this.setNome(nome);
		this.setEmail(email);
	}
	
	    public Cliente(NovoClienteDTO clienteDTO) {
	        this.setNome(clienteDTO.getNome());
	        this.setEmail(clienteDTO.getEmail());
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
	
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	
	
	}
	
}
