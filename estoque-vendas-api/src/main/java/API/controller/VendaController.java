package api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.model.Venda;
import api.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Long id) {
        return vendaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venda> registrarVenda(@RequestBody Venda venda) {
        try {
            Venda vendaSalva = vendaService.registrarVenda(venda);
            return ResponseEntity.ok(vendaSalva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}