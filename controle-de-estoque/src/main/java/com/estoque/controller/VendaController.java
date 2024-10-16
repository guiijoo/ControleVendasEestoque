package com.estoque.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.model.Venda;
import com.estoque.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> exibirVendas() {
        return vendaService.findAll();
    }

    @PostMapping
    public Venda registrarVenda(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

    @GetMapping("/{id}")
    public Venda vendaPorId(@PathVariable Long id) {
        return vendaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.delete(id);
    }
}
