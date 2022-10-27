package br.com.felipeltda.lanchonete.infrastructure.repository;
import br.com.felipeltda.lanchonete.domain.model.Cidade;
import br.com.felipeltda.lanchonete.domain.repository.CidadeRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Cidade> findAll() {
        return manager.createQuery("from Cidade", Cidade.class).getResultList();
    }
    @Override
    public Cidade findById(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public Cidade save(Cidade cidade) {
        System.out.println("cidade: "+cidade.getId());
        return manager.merge(cidade);
    }
    @Override
    @Transactional
    public void deleteById(Cidade cidade) {
        System.out.println("cidade: "+cidade.getId());
        cidade = findById(cidade.getId());
        manager.remove(cidade);
    }
}
