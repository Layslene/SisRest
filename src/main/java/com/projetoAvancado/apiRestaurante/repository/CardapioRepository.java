package com.projetoAvancado.apiRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoAvancado.apiRestaurante.models.Cardapio;




@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>{
	

}
