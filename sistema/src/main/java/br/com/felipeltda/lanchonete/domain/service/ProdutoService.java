package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import br.com.felipeltda.lanchonete.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void cadastrarProduto(Produto produto){
        if(produtoRepository.findAll().contains(produto)){
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }

        produtoRepository.save(produto);
    }

}
