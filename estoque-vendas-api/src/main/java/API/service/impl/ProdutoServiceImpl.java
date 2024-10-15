package api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.model.Produto;
import api.repository.ProdutoRepository;
import api.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        return produtoRepository.findById(id)
                .map(produtoExistente -> {
                    produtoExistente.setNome(produto.getNome());
                    produtoExistente.setPreco(produto.getPreco());
                    produtoExistente.setQuantidadeEstoque(produto.getQuantidadeEstoque());
                    return produtoRepository.save(produtoExistente);
                }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

}
