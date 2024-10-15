package com.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.model.Produto;
import com.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllprodutos() {
        return produtoRepository.findAll();
    }

    public Produto createProduct(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto getproduto(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    public Produto updateproduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteproduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
