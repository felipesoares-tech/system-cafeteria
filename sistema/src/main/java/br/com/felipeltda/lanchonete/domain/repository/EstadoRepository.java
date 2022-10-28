package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
