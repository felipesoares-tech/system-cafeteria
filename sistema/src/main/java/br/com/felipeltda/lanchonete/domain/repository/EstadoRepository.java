package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> listar();
    Estado buscar(Integer id);
    Estado salvar(Estado estado);
    Estado cadastrar();
    void remover(Estado estado);
}
