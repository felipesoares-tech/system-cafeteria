package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
