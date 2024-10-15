package api.service.impl;

import java.util.List;
import java.util.Optional;

import api.model.Produto;
import api.model.Venda;
import api.repository.VendaRepository;
import api.service.ProdutoService;
import api.service.VendaService;

public class VendaServiceImpl implements VendaService{

    private VendaRepository vendaRepository;
    private ProdutoService produtoService;

    public VendaServiceImpl(VendaRepository vendaRepository, ProdutoService produtoService) {
        this.vendaRepository = vendaRepository;
        this.produtoService = produtoService;
    }

    @Override
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    @Override
    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    @Override
    public Venda registrarVenda(Venda venda) {
        Produto produto = produtoService.buscarPorId(venda.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getQuantidadeEstoque() < venda.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente para realizar a venda.");
        }

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - venda.getQuantidade());
        produtoService.atualizar(produto.getId(), produto);

        return vendaRepository.save(venda);
    }
}
