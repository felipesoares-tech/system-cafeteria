package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void removeClient(String clientId) {
        try {
            clientRepository.deleteById(clientId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(clientId);

        } catch (DataIntegrityViolationException e) {
            throw new LinkedEntityException("CLIENTE EM USO");
        }
    }


}
