package com.estoque.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.estoque.model.Compra;
import com.estoque.repository.CompraRepository;

@Service
public class CompraService {

    private CompraRepository compraRepository;

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    public Compra findById(Long id) {
        return compraRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void delete(long id) {
        compraRepository.deleteById(id);
    }
}
