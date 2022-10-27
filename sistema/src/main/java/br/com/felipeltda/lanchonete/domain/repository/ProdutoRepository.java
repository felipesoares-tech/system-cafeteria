package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Produto;

import java.util.List;

public interface ProdutoRepository {
    List<Produto> findAll();
    Produto findById(Long id);
    Produto save(Produto produto);
    void deleteById(Produto produto);
}
