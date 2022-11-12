package br.com.felipeltda.lanchonete.api.controller;

import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeNaoEncontradaException;
import br.com.felipeltda.lanchonete.domain.model.Atendente;
import br.com.felipeltda.lanchonete.domain.repository.AtendenteRepository;
import br.com.felipeltda.lanchonete.domain.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/atendentes")
public class AtendenteController {
    @Autowired
    private AtendenteRepository atendenteRepository;

    @Autowired
    private AtendenteService atendenteService;

    @CrossOrigin
    @GetMapping
    public List<Atendente> findAll(){
        return atendenteRepository.findAll();
    }

    @GetMapping("/{atendenteId}")
    public Atendente findById(@PathVariable String atendenteId){
        return atendenteRepository.findById(atendenteId).orElseThrow(() -> new EntidadeNaoEncontradaException("ATENDENTE NÃO ENCONTRADO!"));
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendente save (@RequestBody Atendente atendente){
        return  atendenteService.cadastrarAtendente(atendente);
    }
}

