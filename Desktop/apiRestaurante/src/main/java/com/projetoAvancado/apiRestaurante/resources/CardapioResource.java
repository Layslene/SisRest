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

import com.projetoAvancado.apiRestaurante.DTO.EditarCardapioDTO;
import com.projetoAvancado.apiRestaurante.DTO.ExibirCardapioDTO;
import com.projetoAvancado.apiRestaurante.DTO.NovoCardapioDTO;
import com.projetoAvancado.apiRestaurante.Services.CardapioService;
import com.projetoAvancado.apiRestaurante.models.Cardapio;


@RestController
@RequestMapping("/api/cardapio")
public class CardapioResource {
	
	@Autowired
	private CardapioService cardapioService;
	
	@PostMapping
	public void addCardapio(@RequestBody NovoCardapioDTO cardDTO) {
		Cardapio cardapio = cardapioService.fromDTO(cardDTO);
		cardapioService.save(cardapio);
	}
	
	@GetMapping
	public List<ExibirCardapioDTO> getCardapio() {
		List<Cardapio> lista = cardapioService.findAll();
		List<ExibirCardapioDTO> listaDTO = lista.stream()
				.map(obj -> new ExibirCardapioDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}
	
	@GetMapping(value = "/{id}")
	public ExibirCardapioDTO getById(@PathVariable("id") Long id){
		Optional<Cardapio> obj = cardapioService.getById(id);
		ExibirCardapioDTO objDTO = new ExibirCardapioDTO(obj.get());
		return objDTO;
	}
	
	@PutMapping(value="/{id}")
	public void updateCardapio(@RequestBody EditarCardapioDTO objDTO, @PathVariable Long id) {
		Cardapio cardapio = cardapioService.fromDTO(objDTO);
		cardapio.setId(id);
		cardapioService.update(id, cardapio);
	}
	
	@DeleteMapping("/{id}")
	public void delCardapio(@PathVariable("id") Long id) {
		cardapioService.delete(id);
	}
}
