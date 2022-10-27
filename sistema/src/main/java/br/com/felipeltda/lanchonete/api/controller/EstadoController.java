package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.model.Estado;
import br.com.felipeltda.lanchonete.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @CrossOrigin
    @GetMapping
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public Estado findById(@PathVariable Integer estadoId) {
        return estadoRepository.findById(estadoId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado save(@RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }
}