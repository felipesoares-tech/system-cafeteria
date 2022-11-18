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
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @GetMapping("/{stateId}")
    public State findById(@PathVariable Integer stateId) {
        return stateRepository.findById(stateId).orElseThrow(() -> new RuntimeException("state not found !"));

    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody State state) {
        try{
            stateService.saveState(state);
            return ResponseEntity.status(HttpStatus.CREATED).body(state);
        }catch (DuplicateEntityException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad");
        }
    }

    @DeleteMapping("/{stateId}")
    public ResponseEntity<Object> removeState(@PathVariable Integer stateId){
        try {
            stateService.removeState(stateId);
            return ResponseEntity.status(HttpStatus.OK).body(String.format("state %d removed!",stateId));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("state not found !");
        }catch (LinkedEntityException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("state is already linked to a city, it was not possible to delete");
        }
    }
}