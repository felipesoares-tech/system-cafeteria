package br.com.felipeltda.lanchonete.api.controller;

import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.Attendant;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.repository.AttendantRepository;
import br.com.felipeltda.lanchonete.domain.service.AttendantService;
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
@RequestMapping("/attendant")
public class AttendantController {
    @Autowired
    private AttendantRepository attendantRepository;

    @Autowired
    private AttendantService attendantService;

    @GetMapping
    public List<Attendant> findAll() {
        return attendantRepository.findAll();
    }

    @GetMapping("/{attendantId}")
    public Attendant findById(@PathVariable String attendantId) {
        return attendantRepository.findById(attendantId).orElseThrow(() -> new EntityNotFoundException("ATENDENTE NÃO ENCONTRADO!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendant save(@RequestBody @Valid Attendant attendant) {
        return attendantService.registerAttendant(attendant);
    }

    @DeleteMapping("/{attendantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String attendantId) {
        attendantService.removeAttendant(attendantId);
    }

    @PutMapping("/{attendantId}")
    public ResponseEntity<Object> updateAttendant(@PathVariable String attendantId, @RequestBody Attendant attendant) {
        Optional<Attendant> currentAttendant = attendantRepository.findById(attendantId);
        if (currentAttendant.isPresent()) {
            BeanUtils.copyProperties(attendant, currentAttendant.get(), "cpf");
            Attendant saveAttendant = attendantRepository.save(currentAttendant.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveAttendant);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("test");
    }

    private void merge(Map<String, Object> sourceData, Attendant targetAttendant) {
        ObjectMapper objectMapper = new ObjectMapper();
        Attendant sourceAttendant = objectMapper.convertValue(sourceData, Attendant.class);

        sourceData.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Attendant.class, nomePropriedade);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, sourceAttendant);

            ReflectionUtils.setField(field, targetAttendant, newValue);
        });
    }

    @PatchMapping("/{attendantId}")
    public ResponseEntity<?> partialUpdate(@PathVariable String attendantId, @RequestBody Map<String, Object> fields){
        Optional<Attendant> currentAttendant = attendantRepository.findById(attendantId);
        currentAttendant.ifPresent(attendant -> merge(fields, attendant));

        return updateAttendant(attendantId,currentAttendant.get());
    }
}

