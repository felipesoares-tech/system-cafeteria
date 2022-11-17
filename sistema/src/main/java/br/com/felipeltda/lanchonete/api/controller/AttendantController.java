package br.com.felipeltda.lanchonete.api.controller;

import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.Attendant;
import br.com.felipeltda.lanchonete.domain.repository.AttendantRepository;
import br.com.felipeltda.lanchonete.domain.service.AttendantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendentes")
public class AttendantController {
    @Autowired
    private AttendantRepository attendantRepository;

    @Autowired
    private AttendantService attendantService;

    @CrossOrigin
    @GetMapping
    public List<Attendant> findAll() {
        return attendantRepository.findAll();
    }

    @GetMapping("/{atendenteId}")
    public Attendant findById(@PathVariable String atendenteId) {
        return attendantRepository.findById(atendenteId).orElseThrow(() -> new EntityNotFoundException("ATENDENTE NÃO ENCONTRADO!"));
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendant save(@RequestBody Attendant attendant) {
        return attendantService.cadastrarAtendente(attendant);
    }

    @DeleteMapping("/{attendantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String attendantId) {
        attendantService.removeAttendant(attendantId);
    }

    @PutMapping("/{attendantId}")
    public ResponseEntity<Object> atualizar(@PathVariable String attendantId, @RequestBody Attendant attendant) {
        Optional<Attendant> currentAttendant = attendantRepository.findById(attendantId);
        if (currentAttendant.isPresent()) {
            BeanUtils.copyProperties(attendant, currentAttendant.get(), "cpf");
            Attendant saveAttendant = attendantRepository.save(currentAttendant.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveAttendant);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TESTE");
    }
}

