package br.com.felipeltda.lanchonete.api.controller;

import br.com.felipeltda.lanchonete.domain.model.Atendente;
import br.com.felipeltda.lanchonete.domain.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/atendentes")
public class AtendenteController {
    @Autowired
    private AtendenteRepository atendenteRepository;
    @CrossOrigin
    @GetMapping
    public List<Atendente> listar(){
        return atendenteRepository.listar();
    }

    @GetMapping("/{atendenteId}")
    public Atendente buscar(@PathVariable Long atendenteId){
        return atendenteRepository.buscar(atendenteId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendente adicionar (@RequestBody Atendente atendente){
        return atendenteRepository.salvar(atendente);
    }
}

