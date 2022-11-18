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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Product findById(@PathVariable Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("product not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save (@RequestBody Product product){
        return productService.registerProduct(product);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable Long productId) {
        productService.removeProduct(productId);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        Optional<Product> currentProduct = productRepository.findById(productId);
        if (currentProduct.isPresent()) {
            BeanUtils.copyProperties(product, currentProduct.get(), "id");
            Product saveProduct = productRepository.save(currentProduct.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveProduct);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("test");
    }

}
