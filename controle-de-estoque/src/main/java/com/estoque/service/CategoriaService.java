package com.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estoque.model.Categoria;
import com.estoque.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategories() {
        return categoriaRepository.findAll();
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria getCategoria(Long id) {
        return categoriaRepository.findById(id).orElseThrow();
    }

    public Categoria updateCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
