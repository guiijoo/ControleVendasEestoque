package api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.model.Venda;
import api.repository.ProdutoRepository;
import api.repository.VendaRepository;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;

    public VendaController(VendaRepository vendaRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<? extends Object> registrarVenda(@RequestBody Venda venda) {
        return produtoRepository.findById(venda.getProduto().getId())
                .map(produto -> {
                    if (produto.getQuantidadeEstoque() >= venda.getQuantidade()) {
                        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - venda.getQuantidade());
                        produtoRepository.save(produto);
                        return ResponseEntity.ok(vendaRepository.save(venda)); // Retorna o objeto Venda corretamente
                    } else {
                        return ResponseEntity.badRequest().build(); // Corrigido para retornar um badRequest sem body
                    }
                }).orElse(ResponseEntity.notFound().build()); // Também corrigido para ResponseEntity<Venda>
    }
}