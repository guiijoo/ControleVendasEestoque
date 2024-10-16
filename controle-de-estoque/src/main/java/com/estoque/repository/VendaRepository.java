package com.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
