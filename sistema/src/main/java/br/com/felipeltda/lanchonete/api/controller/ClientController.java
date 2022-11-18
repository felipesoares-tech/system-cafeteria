package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.repository.ClientRepository;
import br.com.felipeltda.lanchonete.domain.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;
    @GetMapping
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public Client findById(@PathVariable String clientId){
        return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("entity not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client){
        return clientService.registerCustomer(client);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String clientId) {
        clientService.removeClient(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Object> updateClient(@PathVariable String clientId, @RequestBody Client client) {
        Optional<Client> currentClient = clientRepository.findById(clientId);
        if (currentClient.isPresent()) {
            BeanUtils.copyProperties(client, currentClient.get(), "cpf");
            Client saveClient = clientRepository.save(currentClient.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveClient);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("test");
    }
}

