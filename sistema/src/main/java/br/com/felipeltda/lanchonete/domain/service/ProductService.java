package br.com.felipeltda.lanchonete.domain.service;
import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.Product;
import br.com.felipeltda.lanchonete.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void removeProduct(Long clientId) {
        try {
            productRepository.deleteById(clientId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("ENTIDADE NÃO ENCONTRADA");

        } catch (DataIntegrityViolationException e) {
            throw new LinkedEntityException("CLIENTE EM USO");
        }
    }

}
