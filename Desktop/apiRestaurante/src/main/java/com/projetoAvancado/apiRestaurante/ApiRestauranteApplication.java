package com.projetoAvancado.apiRestaurante;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetoAvancado.apiRestaurante.models.Cardapio;
import com.projetoAvancado.apiRestaurante.repository.CardapioRepository;



@SpringBootApplication
public class ApiRestauranteApplication implements CommandLineRunner{
	
	@Autowired
	CardapioRepository cardapioRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestauranteApplication.class, args);
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Cardapio card1 = new Cardapio(null, "macarrão", "Macarrão com molho de Tomate" , 18.00);
		Cardapio  card2 = new Cardapio(null, "Arroz", "Arroz refogado com frango", 19.00);
		Cardapio card3 = new Cardapio(null, "Hambúrguer", "Hamburguer e salada", 3.00);
		
		
	
		
		cardapioRepository.saveAll(Arrays.asList(card1, card2, card3));
		
	}
}

