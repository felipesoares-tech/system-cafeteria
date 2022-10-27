package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Atendente;
import java.util.List;

public interface AtendenteRepository {
    List<Atendente> findAll();
    Atendente findById(Long id);
    Atendente save(Atendente atendente);
    void deleteById(Atendente atendente);
}
