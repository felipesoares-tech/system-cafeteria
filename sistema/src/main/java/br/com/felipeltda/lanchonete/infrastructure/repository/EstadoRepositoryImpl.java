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
    public Estado buscar(Integer id) {
        return manager.find(Estado.class, id);
    }

    @Override
    public Estado cadastrar() {
        return manager.createQuery("from Estado",Estado.class).getSingleResult();
    }

    @Override
    @Transactional
    public Estado salvar(Estado estado) {
        System.out.println("cliente: "+estado.getId());
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        System.out.println("estado: "+estado.getId());
        estado = buscar(estado.getId());
        manager.remove(estado);
    }

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }
}
