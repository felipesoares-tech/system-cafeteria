package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
