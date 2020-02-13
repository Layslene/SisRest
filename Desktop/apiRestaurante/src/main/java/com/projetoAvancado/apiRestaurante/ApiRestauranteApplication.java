package com.projetoAvancado.apiRestaurante;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetoAvancado.apiRestaurante.models.Cardapio;
import com.projetoAvancado.apiRestaurante.models.Cliente;
import com.projetoAvancado.apiRestaurante.repository.CardapioRepository;
import com.projetoAvancado.apiRestaurante.repository.ClienteRepository;



@SpringBootApplication
public class ApiRestauranteApplication implements CommandLineRunner{
	
	@Autowired
	CardapioRepository cardapioRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestauranteApplication.class, args);
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Cardapio card1 = new Cardapio(null, "macarrão", "Macarrão com molho de Tomate" , 18.00);
		Cardapio  card2 = new Cardapio(null, "Arroz", "Arroz refogado com frango", 19.00);
		Cardapio card3 = new Cardapio(null, "Hambúrguer", "Hamburguer e salada", 3.00);
		
		Cliente cli1 = new Cliente(null, "Maria", "Maria@gmail.com", "sdfsdfsdf" );
		Cliente cli2 = new Cliente(null, "João", "joao@gmail.com", "s6798468sdf9");
		Cliente cli3 = new Cliente(null, "Lays", "lays@gmail.com", "s6sdfsdfwe2duiy");
		
	
		clienteRepository.saveAll( Arrays.asList(cli1, cli2,cli3));
		cardapioRepository.saveAll(Arrays.asList(card1, card2, card3));
		
	}
}

