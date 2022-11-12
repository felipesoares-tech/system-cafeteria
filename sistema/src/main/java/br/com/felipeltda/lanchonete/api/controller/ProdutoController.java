package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import br.com.felipeltda.lanchonete.domain.repository.ProdutoRepository;
import br.com.felipeltda.lanchonete.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/produtos")
    public class ProdutoController {
        @Autowired
        private ProdutoRepository produtoRepository;

        @Autowired
        private ProdutoService produtoService;

        @CrossOrigin
        @GetMapping
        public List<Produto> findAll() {
            return produtoRepository.findAll();
        }

        @CrossOrigin
        @GetMapping("/{produtoId}")
        public Produto findById(@PathVariable Long produtoId){
            return produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("PRODUTO NÃO ENCONTRADO!"));
        }

        @CrossOrigin
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Produto save (@RequestBody Produto produto){
                return produtoService.cadastrarProduto(produto);
        }

}
