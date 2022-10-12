package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> listar();
    Cliente buscar(Long id);
    Cliente salvar(Cliente cliente);
    Cliente cadastrar();
    void remover(Cliente cliente);
}
