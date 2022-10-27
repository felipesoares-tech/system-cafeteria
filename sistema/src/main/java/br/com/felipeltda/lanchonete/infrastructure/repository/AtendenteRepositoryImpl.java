package br.com.felipeltda.lanchonete.infrastructure.repository;

import br.com.felipeltda.lanchonete.domain.model.Atendente;
import br.com.felipeltda.lanchonete.domain.repository.AtendenteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class AtendenteRepositoryImpl implements AtendenteRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Atendente> findAll() {
        return manager.createQuery("from Atendente", Atendente.class).getResultList();
    }
    @Override
    public Atendente findById(Long id) {
        return manager.find(Atendente.class, id);
    }

    @Override
    @Transactional
    public Atendente save(Atendente atendente) {
        System.out.println("atendente: "+atendente.getId());
        return manager.merge(atendente);
    }
    @Override
    @Transactional
    public void deleteById(Atendente atendente) {
        System.out.println("atendente: "+atendente.getId());
        atendente = findById(atendente.getId());
        manager.remove(atendente);
    }
}
