package com.projetoAvancado.apiRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoAvancado.apiRestaurante.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}