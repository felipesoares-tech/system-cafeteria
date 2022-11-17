package br.com.felipeltda.lanchonete.domain.service;
import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.model.Product;
import br.com.felipeltda.lanchonete.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product cadastrarProduto(Product product){
        if(productRepository.findAll().contains(product)){
            throw new DuplicateEntityException("PRODUTO INFORMADO JÁ ESTÁ CADASTRADO NO SISTEMA!");
        }
        return productRepository.save(product);
    }

}
