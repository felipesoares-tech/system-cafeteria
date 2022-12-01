package br.com.felipeltda.lanchonete.domain.repository;

import br.com.felipeltda.lanchonete.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
   // List<Order> findOrderById
}
