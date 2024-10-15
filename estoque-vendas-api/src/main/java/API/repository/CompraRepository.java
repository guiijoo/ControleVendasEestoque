package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}