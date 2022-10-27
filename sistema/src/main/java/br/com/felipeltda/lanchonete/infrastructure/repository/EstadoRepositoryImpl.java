package br.com.felipeltda.lanchonete.infrastructure.repository;
import br.com.felipeltda.lanchonete.domain.model.Estado;
import br.com.felipeltda.lanchonete.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Estado findById(Integer id) {
        return manager.find(Estado.class, id);
    }

    @Override
    @Transactional
    public Estado save(Estado estado) {
        System.out.println("cliente: "+estado.getId());
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void deleteById(Estado estado) {
        System.out.println("estado: "+estado.getId());
        estado = findById(estado.getId());
        manager.remove(estado);
    }

    @Override
    public List<Estado> findAll() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }
}
