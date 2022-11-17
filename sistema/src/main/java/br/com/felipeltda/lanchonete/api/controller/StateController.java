package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.State;
import br.com.felipeltda.lanchonete.domain.repository.StateRepository;
import br.com.felipeltda.lanchonete.domain.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateService stateService;

    @CrossOrigin
    @GetMapping
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public State findById(@PathVariable Integer estadoId) {
        return stateRepository.findById(estadoId).orElseThrow(() -> new RuntimeException("ESTADO NÃO ENCONTRADO!"));

    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody State state) {
        try{
            stateService.salvar(state);
            return ResponseEntity.status(HttpStatus.CREATED).body(state);
        }catch (DuplicateEntityException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DEU RUIM");
        }
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Object> remover(@PathVariable Integer estadoId){
        try {
            stateService.remover(estadoId);
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Estado %d removido!",estadoId));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ESTADO NAO ENCONTRADO");
        }catch (LinkedEntityException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estado ja esta vinculado a uma cidade, nao foi possivel deletar");
        }
    }
}