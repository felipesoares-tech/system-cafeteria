package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import br.com.felipeltda.lanchonete.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

        @CrossOrigin
        @GetMapping("/{produtoId}")
        public Produto buscar(@PathVariable Long produtoId){
            return produtoRepository.buscar(produtoId);
        }

        @CrossOrigin
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Produto adicionar (@RequestBody Produto produto){
            return produtoRepository.salvar(produto);
        }

}
