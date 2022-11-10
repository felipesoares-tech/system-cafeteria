package br.com.felipeltda.lanchonete.api.controller;

import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.repository.ClienteRepository;
import br.com.felipeltda.lanchonete.domain.service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;
    @CrossOrigin
    @GetMapping
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public Cliente findById(@PathVariable String clienteId){
        return clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("CPF NÃO ENCONTRADO!"));
    }

    @CrossOrigin
    @PostMapping
    public Cliente save (@RequestBody Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }
}

