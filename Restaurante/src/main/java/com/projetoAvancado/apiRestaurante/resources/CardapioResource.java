package com.projetoAvancado.apiRestaurante.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/cardapio")
@Api(value="Api Rest Cardapio")
@CrossOrigin(origins="*")
public class CardapioResource {
	
	@Autowired
	private CardapioService cardapioService;
	
	@PostMapping
	@ApiOperation(value="Salva um prato no cardapio")
	public void addCardapio(@RequestBody NovoCardapioDTO cardDTO) {
		Cardapio cardapio = cardapioService.fromDTO(cardDTO);
		cardapioService.save(cardapio);
	}
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de pratos do cardapio")
	public List<ExibirCardapioDTO> getCardapio() {
		List<Cardapio> lista = cardapioService.findAll();
		List<ExibirCardapioDTO> listaDTO = lista.stream().map(obj -> new ExibirCardapioDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value="Retorna um prato especifico do cardapio ")
	public ExibirCardapioDTO getById(@PathVariable("id") Long id){
		Optional<Cardapio> obj = cardapioService.getById(id);
		ExibirCardapioDTO objDTO = new ExibirCardapioDTO(obj.get());
		return objDTO;
	}
	
	@PutMapping(value="/{id}")
	@ApiOperation(value="Atualiza um prato do cardapio especifico")
	public void updateCardapio(@RequestBody EditarCardapioDTO objDTO, @PathVariable Long id) {
		Cardapio cardapio = cardapioService.fromDTO(objDTO);
		cardapio.setId(id);
		cardapioService.attCardapio(id, cardapio);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete um prato do cardapio")
	public void delCardapio(@PathVariable("id") Long id) {
		cardapioService.delete(id);
	}
}
