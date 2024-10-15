package api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.model.Compra;
import api.repository.CompraRepository;
import api.repository.ProdutoRepository;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraRepository compraRepository;
    private final ProdutoRepository produtoRepository;

    public CompraController(CompraRepository compraRepository, ProdutoRepository produtoRepository) {
        this.compraRepository = compraRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Compra> registrarCompra(@RequestBody Compra compra) {
        return produtoRepository.findById(compra.getProduto().getId())
                .map(produto -> {
                    produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + compra.getQuantidade());
                    produtoRepository.save(produto);
                    return ResponseEntity.ok(compraRepository.save(compra));
                }).orElse(ResponseEntity.notFound().build());
    }
}