package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Cidade;
import java.util.List;

public interface CidadeRepository {
    List<Cidade> findAll();
    Cidade findById(Long id);
    Cidade save(Cidade cliente);
    void deleteById(Cidade cliente);
}
