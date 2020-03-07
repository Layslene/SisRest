package com.projetoAvancado.apiRestaurante.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAvancado.apiRestaurante.DTO.EditarCardapioDTO;
import com.projetoAvancado.apiRestaurante.DTO.NovoCardapioDTO;
import com.projetoAvancado.apiRestaurante.models.Cardapio;
import com.projetoAvancado.apiRestaurante.repository.CardapioRepository;


@Service
public class CardapioService {
	
	@Autowired
	private CardapioRepository cardapioRepository;
	
	public void save(Cardapio cardapio) {
		cardapioRepository.save(cardapio);
	}
	
	public Optional<Cardapio> getById(Long id) {
		return cardapioRepository.findById(id);
	}
	
	public void update(Long id, Cardapio obj) {
		Optional<Cardapio> objOptional = getById(id);
		if (objOptional.isPresent()) {
			Cardapio objDb = objOptional.get();
			objDb.setValor(obj.getValor());
			objDb.setDescricao(obj.getDescricao());
			objDb.setTitulo(obj.getTitulo());
			cardapioRepository.save(objDb);
		} 
	}
	
	public List<Cardapio> findAll() {
		return cardapioRepository.findAll();
	}

	public void delete(Long id) {
		Optional<Cardapio> card = cardapioRepository.findById(id);
		if (card.isPresent()) {
			cardapioRepository.deleteById(id);
		} 
	}
	
	public Cardapio fromDTO(NovoCardapioDTO cardDTO) {
		Cardapio card = new Cardapio(null, cardDTO.getTitulo(), cardDTO.getDescricao(), cardDTO.getValor());
		return card;
	}
	
	public Cardapio fromDTO(EditarCardapioDTO cardDTO) {
		Cardapio card= new Cardapio(cardDTO.getId(), cardDTO.getTitulo(), cardDTO.getDescricao(), cardDTO.getValor()); 
		
		return card;
	
	}
	
	public void attCardapio(Long id, Cardapio obj) {
		Optional<Cardapio> objOptional = getById(id);
		if (objOptional.isPresent()) {
			Cardapio objDb = objOptional.get();
			objDb.setValor(obj.getValor());
			objDb.setDescricao(obj.getDescricao());
			objDb.setTitulo(obj.getTitulo());
			cardapioRepository.save(objDb);
		} 
	}

}