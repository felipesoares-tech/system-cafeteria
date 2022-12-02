package br.com.felipeltda.lanchonete.domain.repository;
import br.com.felipeltda.lanchonete.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findItemsByOrder_Client_Nome(String name);
    List<Item> findItemsByOrder_Attendant_Nome(String name);

}
