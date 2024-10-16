package com.estoque.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.model.Compra;
import com.estoque.service.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    public CompraService compraService;

    @GetMapping
    public List<Compra> exibirCompras() {
        return compraService.findAll();
    }

    @PostMapping
    public Compra registrarCompra(@RequestBody Compra compra) {
        return compraService.save(compra);
    }
    
    @GetMapping("/{id}")
    public Compra encontrarCompra(@PathVariable Long id) {
        return compraService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCompra(@PathVariable Long id) {
        compraService.delete(id);
    }
    
}
