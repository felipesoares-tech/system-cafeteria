package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Atendente;
import java.util.List;

public interface AtendenteRepository {
    List<Atendente> listar();
    Atendente buscar(Long id);
    Atendente salvar(Atendente atendente);
    Atendente cadastrar();
    void remover(Atendente atendente);
}
