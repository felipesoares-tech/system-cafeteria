package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.model.Estado;
import br.com.felipeltda.lanchonete.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @CrossOrigin
    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.listar();
    }

    @GetMapping("/{estadoId}")
    public Estado buscar(@PathVariable Integer estadoId) {
        return estadoRepository.buscar(estadoId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {
        return estadoRepository.salvar(estado);
    }
}