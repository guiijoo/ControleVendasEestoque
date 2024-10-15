package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
