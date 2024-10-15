package api.service;

import java.util.List;
import java.util.Optional;

import api.model.Venda;

public interface VendaService {
    List<Venda> listarVendas();
    Optional<Venda> buscarPorId(Long id);
    Venda registrarVenda(Venda venda);
}
