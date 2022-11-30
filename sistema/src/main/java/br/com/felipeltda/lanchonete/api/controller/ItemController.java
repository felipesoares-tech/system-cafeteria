package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Item;
import br.com.felipeltda.lanchonete.domain.repository.ItemRepository;
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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @GetMapping("/{itemId}")
    public Item findById(@PathVariable Integer itemId){
        return itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("entity not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item save (@RequestBody @Valid Item item){
        return itemRepository.save(item);
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Object> updateItem(@PathVariable Integer itemId, @RequestBody Item item) {
        Optional<Item> currentItem = itemRepository.findById(itemId);
        if (currentItem.isPresent()) {
            BeanUtils.copyProperties(item, currentItem.get(), "id");
            Item saveItem = itemRepository.save(currentItem.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveItem);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("test");
    }
    private void merge(Map<String, Object> sourceData, Item targetItem) {
        ObjectMapper objectMapper = new ObjectMapper();
        Item sourceItem = objectMapper.convertValue(sourceData, Item.class);

        sourceData.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Item.class, nomePropriedade);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, sourceItem);

            ReflectionUtils.setField(field, targetItem, newValue);
        });
    }
    @PatchMapping("/{itemId}")
    public ResponseEntity<?> partialUpdate(@PathVariable Integer itemId, @RequestBody Map<String, Object> fields){
        Optional<Item> currentItem = itemRepository.findById(itemId);
        currentItem.ifPresent(item -> merge(fields, item));

        return updateItem(itemId,currentItem.get());
    }


}
