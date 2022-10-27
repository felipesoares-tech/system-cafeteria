package br.com.felipeltda.lanchonete.infrastructure.repository;

import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteRepositoryImpl implements ClienteRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Cliente> findAll() {
        return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Override
    public Cliente findById(Long id) {
        return manager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        System.out.println("cliente: "+cliente.getId());
        return manager.merge(cliente);
    }
    @Override
    @Transactional
    public void deleteById(Cliente cliente) {
        System.out.println("cliente: "+cliente.getId());
        cliente = findById(cliente.getId());
        manager.remove(cliente);
    }
}
