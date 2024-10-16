package com.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
