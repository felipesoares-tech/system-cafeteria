package br.com.felipeltda.lanchonete.api.controller;

import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @CrossOrigin
    @GetMapping
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public Cliente findById(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}

