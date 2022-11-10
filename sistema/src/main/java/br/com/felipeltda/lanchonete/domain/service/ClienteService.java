package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.model.Cliente;
import br.com.felipeltda.lanchonete.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void cadastrarCliente(Cliente cliente){
        if(clienteRepository.existsById(cliente.getCpf())){
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }

        clienteRepository.save(cliente);
    }


}
