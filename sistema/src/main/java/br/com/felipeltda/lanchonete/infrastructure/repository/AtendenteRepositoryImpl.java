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
    public List<Atendente> listar() {
        return manager.createQuery("from Atendente", Atendente.class).getResultList();
    }

    @Override
    public Atendente cadastrar() {
        return manager.createQuery("from Atendente",Atendente.class).getSingleResult();
    }

    @Override
    public Atendente buscar(Long id) {
        return manager.find(Atendente.class, id);
    }

    @Override
    @Transactional
    public Atendente salvar(Atendente atendente) {
        System.out.println("atendente: "+atendente.getId());
        return manager.merge(atendente);
    }
    @Override
    @Transactional
    public void remover(Atendente atendente) {
        System.out.println("atendente: "+atendente.getId());
        atendente = buscar(atendente.getId());
        manager.remove(atendente);
    }
}
