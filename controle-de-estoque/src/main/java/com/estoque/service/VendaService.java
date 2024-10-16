package com.estoque.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.estoque.model.Venda;
import com.estoque.repository.VendaRepository;

@Service
public class VendaService {

    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda findById(Long id) {
        return vendaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void delete(long id) {
        vendaRepository.deleteById(id);
    }
}
