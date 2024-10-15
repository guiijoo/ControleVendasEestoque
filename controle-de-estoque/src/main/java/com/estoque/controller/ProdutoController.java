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

import com.estoque.model.Produto;
import com.estoque.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

     private ProdutoService produtoService;
    
    @GetMapping
    public List<Produto> getAllProducts() {
        return produtoService.getAllprodutos();
    }
    
    @PostMapping
    public Produto createProduct(@RequestBody Produto product) {
        return produtoService.createProduct(product);
    }
    
    @GetMapping("/{id}")
    public Produto getProduct(@PathVariable Long id) {
        return produtoService.getproduto(id);
    }
    
    @PutMapping("/{id}")
    public Produto updateProduct(@PathVariable Long id, @RequestBody Produto product) {
        return produtoService.updateproduto(product);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        produtoService.deleteproduto(id);
    }
}
