package api.service;

import java.util.List;
import java.util.Optional;

import api.model.Produto;

public interface ProdutoService {
    List<Produto> listarTodos();

    Optional<Produto> buscarPorId(Long id);

    Produto salvar(Produto produto);

    Produto atualizar(Long id, Produto produto);

    void deletar(Long id);
}
