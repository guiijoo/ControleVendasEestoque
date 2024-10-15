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

import com.estoque.model.Fornecedor;
import com.estoque.service.FornecedorService;

@Controller
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorService.getAllFornecedores();
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.createFornecedor(fornecedor);
    }

    @GetMapping("/{id}")
    public Fornecedor getFornecedor(@PathVariable Long id) {
        return fornecedorService.getFornecedor(id);
    }

    @PutMapping("/{id}")
    public Fornecedor updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.updateFornecedor(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        fornecedorService.deleteFornecedor(id);
    }
}
