package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeNaoEncontradaException;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeVinculadaException;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.model.Estado;
import br.com.felipeltda.lanchonete.domain.repository.EstadoRepository;
import br.com.felipeltda.lanchonete.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoService estadoService;

    @CrossOrigin
    @GetMapping
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public Estado findById(@PathVariable Integer estadoId) {
        return estadoRepository.findById(estadoId).orElseThrow(() -> new RuntimeException("ESTADO NÃO ENCONTRADO!"));

    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Estado estado) {
        try{
            estadoService.salvar(estado);
            return ResponseEntity.status(HttpStatus.CREATED).body(estado);
        }catch (EntidadeDuplicadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DEU RUIM");
        }
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Object> remover(@PathVariable Integer estadoId){
        try {
            estadoService.remover(estadoId);
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Estado %d removido!",estadoId));
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ESTADO NAO ENCONTRADO");
        }catch (EntidadeVinculadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estado ja esta vinculado a uma cidade, nao foi possivel deletar");
        }
    }
}