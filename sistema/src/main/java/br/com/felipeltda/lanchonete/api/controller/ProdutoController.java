package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import br.com.felipeltda.lanchonete.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/produtos")
    public class ProdutoController {
        @Autowired
        private ProdutoRepository produtoRepository;
        @CrossOrigin
        @GetMapping
        public List<Produto> listar() {
            return produtoRepository.listar();
        }

}
