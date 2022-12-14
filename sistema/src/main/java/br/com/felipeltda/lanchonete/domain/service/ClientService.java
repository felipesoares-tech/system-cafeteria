package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.InvalidCpfException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.repository.ClientRepository;
import br.com.felipeltda.lanchonete.domain.util.CpfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client registerCustomer(Client client){
        if(clientRepository.findAll().contains(client)){
            throw new DuplicateEntityException("this entity is already registered in the system !");
        }else if(!CpfValidator.isCPF(client.getCpf())){
            throw new InvalidCpfException("invalid cpf!");
        }

        return clientRepository.save(client);
    }

    public void removeClient(Integer clientId) {
        try {
            clientRepository.deleteById(clientId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("entity not found!");

        } catch (DataIntegrityViolationException e) {
            throw new LinkedEntityException("Linked Entity");
        }
    }


}
