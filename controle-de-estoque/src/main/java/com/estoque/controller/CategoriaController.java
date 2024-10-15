package com.estoque.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estoque.model.Categoria;
import com.estoque.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;
    
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategories();
    }
    
    @PostMapping
    public Categoria createcategoria(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }
    
    @GetMapping("/{id}")
    public Categoria getcategoria(@PathVariable Long id) {
        return categoriaService.getCategoria(id);
    }
    
    @PutMapping("/{id}")
    public Categoria updatecategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(categoria);
    }
    
    @DeleteMapping("/{id}")
    public void deletecategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }

}
