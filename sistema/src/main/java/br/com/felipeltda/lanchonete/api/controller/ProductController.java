package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Product;
import br.com.felipeltda.lanchonete.domain.repository.ProductRepository;
import br.com.felipeltda.lanchonete.domain.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{produtoId}")
    public Product findById(@PathVariable Long produtoId){
        return productRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("PRODUTO NÃO ENCONTRADO!"));
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save (@RequestBody Product product){
        return productService.cadastrarProduto(product);
    }

    @DeleteMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long produtoId) {
        productService.removeProduct(produtoId);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Object> atualizar(@PathVariable Long productId, @RequestBody Product product) {
        Optional<Product> currentProduct = productRepository.findById(productId);
        if (currentProduct.isPresent()) {
            BeanUtils.copyProperties(product, currentProduct.get(), "id");
            Product saveProduct = productRepository.save(currentProduct.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveProduct);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TESTE");
    }

}
