package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
