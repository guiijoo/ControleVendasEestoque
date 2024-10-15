package com.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{
}
