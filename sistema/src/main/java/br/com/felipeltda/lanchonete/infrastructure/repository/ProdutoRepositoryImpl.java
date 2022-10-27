package br.com.felipeltda.lanchonete.infrastructure.repository;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import br.com.felipeltda.lanchonete.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Produto> findAll() {
        return manager.createQuery("from Produto", Produto.class).getResultList();
    }
    @Override
    public Produto findById(Long id) {
        return manager.find(Produto.class, id);
    }
    @Override
    @Transactional
    public Produto save(Produto produto) {
        System.out.println("produto: "+produto.getId());
        return manager.merge(produto);
    }
    @Override
    @Transactional
    public void deleteById(Produto produto) {
        System.out.println("produto: "+produto.getId());
        produto = findById(produto.getId());
        manager.remove(produto);
    }
}
