package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Order;
import br.com.felipeltda.lanchonete.domain.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public Order findById(@PathVariable Integer orderId){
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("entity not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order save (@RequestBody @Valid Order order){
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Object> updateOrder(@PathVariable Integer orderId, @RequestBody Order order) {
        Optional<Order> currentOrder = orderRepository.findById(orderId);
        if (currentOrder.isPresent()) {
            BeanUtils.copyProperties(order, currentOrder.get(), "id");
            Order saveOrder = orderRepository.save(currentOrder.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveOrder);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("test");
    }
    private void merge(Map<String, Object> sourceData, Order targetOrder) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order sourceOrder = objectMapper.convertValue(sourceData, Order.class);

        sourceData.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Order.class, nomePropriedade);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, sourceOrder);

            ReflectionUtils.setField(field, targetOrder, newValue);
        });
    }
    @PatchMapping("/{orderId}")
    public ResponseEntity<?> partialUpdate(@PathVariable Integer orderId, @RequestBody Map<String, Object> fields){
        Optional<Order> currentOrder = orderRepository.findById(orderId);
        currentOrder.ifPresent(order -> merge(fields, order));

        return updateOrder(orderId,currentOrder.get());
    }
}
