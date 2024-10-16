package com.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estoque.model.Fornecedor;
import com.estoque.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor createFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getFornecedor(Long id) {
        return fornecedorRepository.findById(id).orElseThrow();
    }

    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
