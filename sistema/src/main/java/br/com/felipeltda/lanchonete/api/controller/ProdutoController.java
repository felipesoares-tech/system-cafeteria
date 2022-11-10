package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import br.com.felipeltda.lanchonete.domain.repository.ProdutoRepository;
import br.com.felipeltda.lanchonete.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<Object> save (@RequestBody Produto produto){
            try {
                produtoService.cadastrarProduto(produto);
                return ResponseEntity.status(HttpStatus.CREATED).body(produto);
            }catch (EntidadeDuplicadaException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PRODUTO INFORMADO JÁ CONSTA NO BANCO DE DADOS!");
            }
        }

}
