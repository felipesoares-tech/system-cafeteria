package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client cadastrarCliente(Client client){
        if(clientRepository.existsById(client.getCpf())){
            throw new DuplicateEntityException("CLIENTE INFORMADO JÁ ESTÁ CADASTRADO NO SISTEMA!");
        }

        return clientRepository.save(client);
    }


}
