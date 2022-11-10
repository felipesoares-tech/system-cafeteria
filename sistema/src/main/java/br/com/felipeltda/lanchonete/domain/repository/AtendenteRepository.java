package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendenteRepository extends JpaRepository<Atendente, String > {
}
