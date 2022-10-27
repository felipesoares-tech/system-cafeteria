package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> findAll();
    Estado findById(Integer id);
    Estado save(Estado estado);
    void deleteById(Estado estado);
}
