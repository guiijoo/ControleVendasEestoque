package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
