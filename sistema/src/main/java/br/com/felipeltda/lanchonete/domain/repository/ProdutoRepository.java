package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Produto;

import java.util.List;

public interface ProdutoRepository {
    List<Produto> listar();
    Produto buscar(Long id);
    Produto salvar(Produto produto);
    void remover(Produto produto);
}
