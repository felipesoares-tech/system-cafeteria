package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.repository.ClientRepository;
import br.com.felipeltda.lanchonete.domain.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
    public Client findById(@PathVariable Integer clientId){
        return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("entity not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody @Valid Client client){
        return clientService.registerCustomer(client);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer clientId) {
        clientService.removeClient(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Object> updateClient(@PathVariable Integer clientId, @RequestBody Client client) {
        Optional<Client> currentClient = clientRepository.findById(clientId);
        if (currentClient.isPresent()) {
            BeanUtils.copyProperties(client, currentClient.get(), "cpf");
            Client saveClient = clientRepository.save(currentClient.get());
            return ResponseEntity.status(HttpStatus.OK).body(saveClient);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("test");
    }
    private void merge(Map<String, Object> sourceData, Client targetClient) {
        ObjectMapper objectMapper = new ObjectMapper();
        Client sourceClient = objectMapper.convertValue(sourceData, Client.class);

        sourceData.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Client.class, nomePropriedade);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, sourceClient);

            ReflectionUtils.setField(field, targetClient, newValue);
        });
    }
        @PatchMapping("/{clientId}")
        public ResponseEntity<?> partialUpdate(@PathVariable Integer clientId, @RequestBody Map<String, Object> fields){
            Optional<Client> currentClient = clientRepository.findById(clientId);
            currentClient.ifPresent(client -> merge(fields, client));

            return updateClient(clientId,currentClient.get());
    }


}

